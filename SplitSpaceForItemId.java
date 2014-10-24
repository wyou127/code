import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created: 10/10/14 3:34 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class SplitSpaceForItemId {

    public static void main(String[] args) {
        SplitSpaceForItemId SplitSpaceForItemId = new SplitSpaceForItemId();
        SplitSpaceForItemId.getFile();
    }

    public void getFile() {

        String inputFile = "/Users/wyou/Desktop/storefront.csv";
        BufferedReader br = null;
        String line = "";
        String inputSplitBy1= ",";
        String inputSplitBy = " ";


        try {

            br = new BufferedReader(new FileReader(inputFile));

            while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] data = line.split(inputSplitBy1);
                    String []data2 = data[1].split(inputSplitBy);
                    System.out.println(data[0] + "," + data2[4]);

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
    }
}
