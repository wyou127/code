package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: 10/24/14 4:06 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class GraphNode {

    String val;

    List<GraphNode> children;

    GraphNode(String s) { val = s; children = new ArrayList<GraphNode>();}

    public void addChild(GraphNode child) {
        children.add(child);
    }

}
