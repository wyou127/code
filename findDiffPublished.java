import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created: 10/28/14 2:09 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class findDiffPublished {


    public static void main(String[] args ) {
        findDiffPublished find = new findDiffPublished();

        String item_store = "/Users/wyou/Desktop/published_bundles.csv" ;
        String grouping = "/Users/wyou/Desktop/published_bundle_grouping.csv";
        Map is = find.getId(item_store);
        Map gp = find.getId(grouping);

        Map<String,String> delta = find.findDelta(is, gp);

        System.out.println(delta.size());

    }


    /**
     * find list in source not in target.
     * @param source
     * @param target
     * @return
     */
    public Map<String,String> findDelta(Map<String,String> source, Map<String,String> target) {
        Map<String,String> result = new HashMap<String,String>();

        for (String s : source.keySet()) {
            if (!target.containsKey(s)) {
                result.put(s,source.get(s));
                System.out.print(source.get(s)+",");
            }
        }
        return result;
    }

    public Map<String,String> getId(String path) {

        Map<String,String> result = new HashMap<String,String>();
        BufferedReader br = null;
        String line = "";
        String splitter = ",";

        try {

            br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                String id = line.split(splitter)[1];
                String pid = line.split(splitter)[0];
                result.put(id,pid);
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
