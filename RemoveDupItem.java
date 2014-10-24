import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created: 7/10/14 4:04 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class RemoveDupItem {

    public static void main(String[] args) {
        RemoveDupItem removeDupItem = new RemoveDupItem();
        Map<String, Duplicate> result = removeDupItem.getDistilledMap();

        int count = 0;
        for (Map.Entry<String, Duplicate> entry : result.entrySet()) {
            Duplicate dup = entry.getValue();
            if (dup.getDuplicate()) {
                System.out.println(entry.getKey());
                count++;
            }
        }
        System.out.println("Total Count: " + count);

    }

    public Map<String, Duplicate> getDistilledMap() {

        String inputFile = "/Users/wyou/data/kit_item.sql";
        BufferedReader br = null;
        String line = "";
        String inputSplitBy = ",";
        Map<String, Duplicate> distilledMap = new HashMap<String, Duplicate>();

        try {

            br = new BufferedReader(new FileReader(inputFile));

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(inputSplitBy);
                String kit_id = data[14];
                String item_id = data[13];
                if (distilledMap.containsKey(kit_id)) {
                    Duplicate dup = distilledMap.get(kit_id);
                    if (dup.getItemIds().contains(item_id)) {
                        dup.setDuplicate(true);
                        distilledMap.put(kit_id, dup);
                    } else {
                        dup.addItemIds(item_id);
                    }
                } else {
                    Duplicate dup = new Duplicate();
                    dup.addItemIds(item_id);
                    distilledMap.put(kit_id, dup);
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

        System.out.println(distilledMap.size());
        System.out.println("Done");
        return distilledMap;
    }
}
