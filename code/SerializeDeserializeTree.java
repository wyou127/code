package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: 10/7/14 4:12 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class SerializeDeserializeTree {
    public String serializeTree(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return null;
        } else {
            serializeTreeHelper(root,result);
            return result.toString();
        }

    }

    public void serializeTreeHelper(TreeNode root, List<String> result) {
        if (root == null) {
            result.add("#");
            return;
        } else {
            result.add(Integer.toString(root.val));
            serializeTreeHelper(root.left, result);
            serializeTreeHelper(root.right, result);
        }
    }

    public void addNode (TreeNode root, String val) {
        if ("#".equals(root.sign)) {
            return;
        } else {
            TreeNode newNode = new TreeNode(val.substring(0,1));
            root = newNode;
            val = val.substring(1);
            addNode(root.left, val);
            addNode(root.left, val);
        }
    }

}
