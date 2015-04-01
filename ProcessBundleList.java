import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created: 11/10/14 2:21 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class ProcessBundleList {


    public void getDistilledMap() {

        String inputFile = "/Users/wyou/Desktop/BundleList.csv";
        BufferedReader br = null;
        String line = "";
        String inputSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(inputFile));

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(inputSplitBy);
                String UUID = data[1].toLowerCase();
                UUID = UUID.replaceAll(
                        "(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})",
                        "$1-$2-$3-$4-$5");
                System.out.println(data[0] +","+ UUID);
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

    }



    public static void main(String[] args) {
        ProcessBundleList processbundleList= new ProcessBundleList();
        processbundleList.getDistilledMap();
    }

}
