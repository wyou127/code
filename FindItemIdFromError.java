import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created: 8/25/14 1:41 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class FindItemIdFromError {

    public static void main(String[] args) {
        FindItemIdFromError findItemIdFromError = new FindItemIdFromError();
        findItemIdFromError.write(findItemIdFromError.getFile());
    }

    public List<String> getFile() {

        List<String> result = new ArrayList<String>();
        String inputFile = "/Users/wyou/Desktop/storeFrontMissing.csv";
        BufferedReader br = null;
        String line = "";
        String inputSplitBy = " itemId ";
        String inputSplitBy2 = "\\..";

        try {

            br = new BufferedReader(new FileReader(inputFile));

            while ((line = br.readLine()) != null) {
                if (line.startsWith("\"GROUP_CB_CHANGELOG\"")) {
                    // use comma as separator
                    String[] data = line.split(inputSplitBy);
                    String itemId = data[1].split(inputSplitBy2)[0];
                    itemId = itemId.replaceAll("\\s+", "");
                    result.add(itemId);
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
        System.out.println("Done");
        return result;
    }

    public void write(List<String> result) {

        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("/tmp/ItemOfferFrontMissing.csv"), "utf-8"));
            for (String itemId : result) {
                writer.write(itemId + "," + "\n");
            }

        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
            }
        }

    }
}
