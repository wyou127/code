package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: 9/3/14 5:14 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class BinaryTreePostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<Integer>();
        buildList(root, result);
        return result;

    }

    public void buildList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        buildList(root.left, list);
        buildList(root.right, list);
        list.add(root.val);
    }
}
