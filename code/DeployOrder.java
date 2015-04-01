package code;

/**
 * Created: 10/24/14 2:42 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 *
 * Input format
 * /**
 * a : b, c
 * b : c, d
 * c : d, e, f
 * j : k
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeployOrder {

    public String order(String path) {

        try {
            //build the forest
            Set<GraphNode> forest = new HashSet<GraphNode>();
            Map<String, GraphNode> locationMap = new HashMap<String, GraphNode>();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String target = line.split(":")[0];
                String[] dependee = line.split(":")[1].split(",");
                buildForest(forest, target, dependee, locationMap);
            }


            // post order traverse forest list.

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;
    }

    public void buildForest(Set<GraphNode> forest, String target, String[] dependee, Map<String, GraphNode> locationMap) {
        GraphNode current;
        if (locationMap.containsKey(target)) {
            current = locationMap.get(target);
        } else {
            current = new GraphNode(target);
            locationMap.put(target, current);
        }

        for (String node : dependee) {
            if (locationMap.containsKey(node)) {
                current.addChild(locationMap.get(node));
                if (forest.contains(locationMap.get(node))) {
                    forest.remove(locationMap.get(node));
                    forest.add(current);
                }
            } else {
                GraphNode newNode = new GraphNode(node);
                current.addChild(newNode);
                locationMap.put(node, newNode);
            }
        }
    }


}

