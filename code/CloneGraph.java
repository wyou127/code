package code;

/**
 * Created: 9/30/14 9:56 AM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:

 1
 / \
 /   \
 0 --- 2
 / \
 \_/
 */


import java.util.*;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 * int label;
 * List<UndirectedGraphNode> neighbors;
 * UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> nodeToNode = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode headNode = new UndirectedGraphNode(node.label);
        nodeToNode.put(node, headNode);
        Queue<UndirectedGraphNode> toVisit = new LinkedList<UndirectedGraphNode>();
        toVisit.add(node);

        while (toVisit.size() != 0) {
            UndirectedGraphNode current = toVisit.remove();
            List<UndirectedGraphNode> neighbors = current.neighbors;

            for (UndirectedGraphNode neighbor : neighbors) {
                if (!nodeToNode.containsKey(neighbor)) {
                    UndirectedGraphNode tmp = new UndirectedGraphNode(neighbor.label);
                    nodeToNode.put(neighbor, tmp);
                    nodeToNode.get(current).neighbors.add(tmp);
                    toVisit.add(neighbor);
                } else {
                    nodeToNode.get(current).neighbors.add(nodeToNode.get(neighbor));
                }
            }
        }
        return headNode;
    }
}
