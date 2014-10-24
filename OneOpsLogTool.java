/**
 * Created: 9/22/14 11:08 AM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */

import com.jcraft.jsch.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class OneOpsLogTool {

    private static final String USER = "app";

    /**
     * @param arg 1. keyword
     *            2. id_rsa path
     *            3. result file  // default SYS out.
     */
    public static void main(String[] arg) {

        try {
            OneOpsLogTool oneOpsLogTool = new OneOpsLogTool();

            // get IpList;
            String authToken = "XzvUvgHgMFBpj93pH4sv";
            authToken = authToken + ":";

            //call oneOps for response
            String oneOpsResponse = oneOpsLogTool.curl(authToken);

            //parse response for the ipList;
            java.util.List<String> ipList = oneOpsLogTool.parseResponse(oneOpsResponse);

            //select private key
            JSch jsch = new JSch();
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Choose your privatekey(ex. ~/.ssh/id_rsa)");
            chooser.setFileHidingEnabled(false);
            int returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose " +
                        chooser.getSelectedFile().getAbsolutePath() + ".");
                jsch.addIdentity(chooser.getSelectedFile().getAbsolutePath());
            }


            //grep command execution
            String keyWord = JOptionPane.showInputDialog("Enter Keyword",
                    "ERROR");
            String command = "grep '" + keyWord + "' /log/logmon/*";


            //execute command in the host, can be extended to any command.
            String outputPath = "/tmp/output";
            oneOpsLogTool.connExecute(jsch, ipList, command, outputPath);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void connExecute(JSch jsch, java.util.List<String> ipList, String command, String absolutePath) throws JSchException, IOException {
        //clear the current output file
        FileOutputStream writer = new FileOutputStream(absolutePath);
        writer.write((new String()).getBytes());
        writer.close();

        for (String host : ipList) {
            Session session = jsch.getSession(USER, host, 22);

            //bypass the authenticity check
            Properties prop = new Properties();
            prop.setProperty("StrictHostKeyChecking", "no");
            session.setConfig(prop);

            // username and passphrase will be given via UserInfo interface.
            UserInfo ui = new MyUserInfo();
            session.setUserInfo(ui);
            session.connect();

            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);

            channel.setInputStream(null);

            //channel.setOutputStream(System.out);

            //FileOutputStream fos=new FileOutputStream("/tmp/stderr");
            //((ChannelExec)channel).setErrStream(fos);
            ((ChannelExec) channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();

            channel.connect();

            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.println(new String(tmp, 0, i));
                    writeToFile(new String(tmp, 0, i), absolutePath);
                }
                if (channel.isClosed()) {
                    if (in.available() > 0) continue;
                    System.out.println("exit from host:" + host);
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                }
            }
            channel.disconnect();
            session.disconnect();
        }
    }

    private void writeToFile(String value, String absolutePath) {
        Writer writer = null;

        try {
            FileWriter fileWriter = new FileWriter(absolutePath,true);
            writer = new BufferedWriter(fileWriter);
            writer.write(value);
        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
            }
        }
    }
    /*
    curl -i -u XzvUvgHgMFBpj93pH4sv: -H "Content-Type:application/json" -H "Accept:application/json"
    -X GET -k -3 -v
    "https://oneops.prod.walmart.com/services/assemblies/product-grouping/operations/environments/prod/platforms/group-setup/components/compute/instances.json?instances_state=all"
     */

    private String curl(String authToken) {

        try {
            ProcessBuilder pb = new ProcessBuilder("curl", "-i", "-u", authToken, "-H", "Content-Type: application/json",
                    "-H", "Accept: application/json", "-X", "GET", "-k", "-3", "-v", "https://oneops.prod.walmart.com/services/assemblies/product-grouping/operations/environments/prod/platforms/group-setup/components/compute/instances.json?instances_state=all");

            pb.redirectErrorStream(true);
            Process p = pb.start();
            InputStream is = p.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Content-Type")) {
                    br.readLine();
                    String line1 = br.readLine();
                    br.readLine();
                    br.readLine();
                    String line2 = br.readLine();
                    line = line1 + line2;
                    System.out.println(line);
                    return line;
                }
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    private java.util.List<String> parseResponse(String response) {
        try {
            JSONArray jsonArray = new JSONArray(response);

            java.util.List<String> ipList = new ArrayList<String>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                JSONObject innerObject = (JSONObject) object.get("ciAttributes");
                String ip = innerObject.get("public_ip").toString();
                ipList.add(ip);
            }
            return ipList;
        } catch (JSONException je) {
            System.out.println(je);
            return null;
        }
    }

    public static class MyUserInfo implements UserInfo, UIKeyboardInteractive {
        final GridBagConstraints gbc =
                new GridBagConstraints(0, 0, 1, 1, 1, 1,
                        GridBagConstraints.NORTHWEST,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0);
        String passphrase;
        JTextField passphraseField = (JTextField) new JPasswordField(20);
        private Container panel;

        public String getPassword() {
            return null;
        }

        public boolean promptYesNo(String str) {
            Object[] options = {"yes", "no"};
            int foo = JOptionPane.showOptionDialog(null,
                    str,
                    "Warning",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
            return foo == 0;
        }

        public String getPassphrase() {
            return passphrase;
        }

        public boolean promptPassphrase(String message) {
            Object[] ob = {passphraseField};
            int result =
                    JOptionPane.showConfirmDialog(null, ob, message,
                            JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                passphrase = passphraseField.getText();
                return true;
            } else {
                return false;
            }
        }

        public boolean promptPassword(String message) {
            return true;
        }

        public void showMessage(String message) {
            JOptionPane.showMessageDialog(null, message);
        }

        public String[] promptKeyboardInteractive(String destination,
                                                  String name,
                                                  String instruction,
                                                  String[] prompt,
                                                  boolean[] echo) {
            panel = new JPanel();
            panel.setLayout(new GridBagLayout());

            gbc.weightx = 1.0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.gridx = 0;
            panel.add(new JLabel(instruction), gbc);
            gbc.gridy++;

            gbc.gridwidth = GridBagConstraints.RELATIVE;

            JTextField[] texts = new JTextField[prompt.length];
            for (int i = 0; i < prompt.length; i++) {
                gbc.fill = GridBagConstraints.NONE;
                gbc.gridx = 0;
                gbc.weightx = 1;
                panel.add(new JLabel(prompt[i]), gbc);

                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.weighty = 1;
                if (echo[i]) {
                    texts[i] = new JTextField(20);
                } else {
                    texts[i] = new JPasswordField(20);
                }
                panel.add(texts[i], gbc);
                gbc.gridy++;
            }

            if (JOptionPane.showConfirmDialog(null, panel,
                    destination + ": " + name,
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE)
                    == JOptionPane.OK_OPTION) {
                String[] response = new String[prompt.length];
                for (int i = 0; i < prompt.length; i++) {
                    response[i] = texts[i].getText();
                }
                return response;
            } else {
                return null;  // cancel
            }
        }
    }
}