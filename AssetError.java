import java.io.*;
import java.util.Map;

/**
 * Created: 10/8/14 3:52 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class AssetError {

    public void getDistilledMap() {

        String inputFile = "/Users/wyou/Desktop/export.csv";
        BufferedReader br = null;
        String line = "";
        int count =0;

        try {

            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("/tmp/bundle.sql"), "utf-8"));

            br = new BufferedReader(new FileReader(inputFile));

            while ((line = br.readLine()) != null) {
                if (line.contains("PPOServiceInvoker: PPO jobId")) {
                    /*if (line.contains("ISC_ITP_VAL_209112")) {
                        StringBuilder sb = new StringBuilder();
                        String data[] = line.split(",");
                        sb.append(data[0]+",");
                        String data2[]  = data[3].split("AssetDownloadService\"");
                        String data3[]  = data2[1].split("context");
                        sb.append("<context section=\"AssetDownloadService"+ data3[0] + "context>");

                        System.out.println(sb.toString());
                        writer.write(line + "\n");
                        count++;
                    }

                    if (line.contains("SYSTEM_ERROR")){
                        count++;
                        System.out.println(line);
                    }    */
                    if(line.contains("ISC_ITP_VAL_301200")) {
                        System.out.println(line.split(",")[0]);
                        count++;
                    }

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        AssetError assetError = new AssetError();
        assetError.getDistilledMap();
    }


}
