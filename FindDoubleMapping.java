import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created: 11/18/14 3:10 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class FindDoubleMapping {

    public static void main(String[] args) {
        FindDoubleMapping findDoubleMapping = new FindDoubleMapping();
        findDoubleMapping.getFile();
    }

    public List<String> getFile() {

        List<String> result = new ArrayList<String>();
        String inputFile = "/Users/wyou/Desktop/bundle_ids_regular_verification_itemstore.csv";
        BufferedReader br = null;
        String line = "";
        String inputSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(inputFile));

            while ((line = br.readLine()) != null) {

                    String[] data = line.split(inputSplitBy);
                    if (data.length >5) {
                        if (data[1].equals(data[5])) {
                            System.out.println(line);
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
        System.out.println("Done");
        return result;
    }

}
