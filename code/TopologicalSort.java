package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created: 4/5/15 4:23 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class TopologicalSort {
    public List<GraphNode> topologicalSort(List<GraphNode> vertices) {
        List<GraphNode> result = new ArrayList<GraphNode>();
        LinkedList<GraphNode> stack = new LinkedList<GraphNode>(vertices);

        //Visited.

        while (!stack.isEmpty()) {
            GraphNode current = stack.pop();
            result.add(current);

            List<GraphNode> adjacentNodes = current.children;

            for (GraphNode node : adjacentNodes) {
                stack.push(node);
            }
        }
        return result;
    }
}
