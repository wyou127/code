package code;

/**
 * Created: 4/5/15 6:21 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left ==null) {
            return 1+minDepth(root.right);
        } else if (root.right == null) {
            return 1+ minDepth(root.left);
        } else {
            return Math.min(1+minDepth(root.left), 1+minDepth(root.right));
        }
    }


}
