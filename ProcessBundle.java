/**
 * Created: 4/30/14 4:34 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ProcessBundle {
    public static void main(String[] args) {

        ProcessBundle obj = new ProcessBundle();
        Set itemSet = obj.getItemSet();
        List<Bundle> bundles = obj.getBundles();
        obj.writeResult(bundles, itemSet);
    }

    public Set<String> getItemSet() {

        String csvFile = "/Users/wyou/python/item.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Set<String> itemSet = new HashSet<String>();

        try {

            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                itemSet.add(data[1]);

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
        itemSet.remove("ITEM_ID");

        System.out.println(itemSet.size());
        System.out.println("Done");
        return itemSet;
    }

    public Set<String> getItemSet2() {

        String csvFile = "/Users/wyou/python/export.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Set<String> itemSet = new HashSet<String>();

        try {

            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                String itemId = data[3];
                itemId = itemId.replace("\"", "");
                itemSet.add(itemId);
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
        itemSet.remove("ITEM_ID");

        System.out.println("Total Ingested Item Size: " + itemSet.size());
        return itemSet;
    }

    public Set<String> getItemSet3() {

        String csvFile = "/Users/wyou/python/IRO_report.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Set<String> itemSet = new HashSet<String>();

        try {

            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                if (data.length > 7 && data[7].equals("SUCCESS")) {
                    itemSet.add(data[0]);
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
        itemSet.remove("ITEM_ID");

        System.out.println(itemSet.size());
        System.out.println("Done");
        return itemSet;
    }

    public List<Bundle> getBundles() {

        String csvFile = "/Users/wyou/python/data";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<Bundle> bundleList = new ArrayList<Bundle>();

        String bundleId = "";
        Bundle bundle = null;
        try {

            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                if (!bundleId.equals(data[0])) {
                    bundleList.add(bundle);
                    bundle = new Bundle(data[0]);
                    bundle.addComponents(data[1]);
                    bundleId = data[0];
                } else {
                    bundle.addComponents(data[1]);
                }
            }
            bundleList.add(bundle);
            bundleList.remove(0);
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
        System.out.println(bundleList.size());
        System.out.println("Done");
        return bundleList;
    }

    public void writeResult(List<Bundle> bundleList, Set<String> itemSet) {
        int count = 0;
        boolean complete = true;

        for (Bundle bundle : bundleList) {
            complete = true;
            List<String> componentList = bundle.getComponentList();
            for (String component : componentList) {
                if (!itemSet.contains(component)) {
                    count++;
                    complete = false;
                    break;
                }
            }
            if (complete) {
                //System.out.println("BundleId: |" + bundle.getId() + "| ComponentId: |" + bundle.componentToString());
                System.out.println("BundleId: " + bundle.getId());

            }
        }
        System.out.println(bundleList.size() - count);
    }
}


