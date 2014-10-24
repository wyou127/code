import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created: 7/10/14 10:15 AM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class DistillBundle {

    public static void main(String[] args) {
        DistillBundle distillBundle = new DistillBundle();
        Map<String, String> result = distillBundle.getDistilledMap();

        /*for (Map.Entry<String, String> entry: result.entrySet()){
            System.out.println(entry.getValue());
        }   */
        System.out.println(result.size());
        distillBundle.write(result);

    }

    public Map<String, String> getDistilledMap() {

        String inputFile = "/Users/wyou/data/bundle_dump.sql";
        BufferedReader br = null;
        String line = "";
        String inputSplitBy = ",";
        Map<String, String> distilledMap = new HashMap<String, String>();

        try {

            br = new BufferedReader(new FileReader(inputFile));

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(inputSplitBy);
                distilledMap.put(data[35], line);
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

        System.out.println(distilledMap.size());
        System.out.println("Done");
        return distilledMap;
    }

    public void write(Map<String, String> map) {

        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("/tmp/bundle.sql"), "utf-8"));
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.write(entry.getValue() +"\n");
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
