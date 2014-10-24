import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created: 8/21/14 3:21 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class FindBundleFromItems {
    public static void main(String[] args) {
        FindBundleFromItems findBundleFromItems = new FindBundleFromItems();
        Set<String> bundleSet = findBundleFromItems.getItemSet();


        System.out.println(bundleSet.size());

        findBundleFromItems.getBundleSet(bundleSet);

    }

    public Set<String> getItemSet() {

        String inputFile = "/Users/wyou/Desktop/BundlesForFinalListOfItems.csv";
        BufferedReader br = null;
        String line = "";
        Set<String> itemIdSet = new HashSet<String>();
        Map<String, String> distilledMap = new HashMap<String, String>();

        try {

            br = new BufferedReader(new FileReader(inputFile));

            while ((line = br.readLine()) != null) {
                itemIdSet.add(line);
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
        return itemIdSet;
    }

    public void getBundleSet(Set<String> itemSet) {

        List<String> itemList = new ArrayList<String> (itemSet);
        List<String> subList;
        int length = itemList.size();
        for (int i=0; i<6; i++) {
            StringBuilder sb = new StringBuilder();
            int start = i* (length/6);
            int end = (i+1)* (length/6) ;
            subList = itemList.subList(start,end);
            for (String item : subList) {
                sb.append(item + ",");

            }
            String list = "(" + sb.toString().substring(0, sb.length() - 1) + ")";
            System.out.println(list);
        }
        subList = itemList.subList(6*(length/6),length );
        StringBuilder sb = new StringBuilder();
        for (String item : subList) {
            sb.append(item + ",");

        }
        String list = "(" + sb.toString().substring(0, sb.length() - 1) + ")";
        System.out.println(list);

        }


}
