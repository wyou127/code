package code;

/**
 * Created: 10/1/14 11:16 AM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class MaximumDeepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root ==null) {
            return 0;
        } else {
            return Math.max(1+ maxDepth(root.left), 1+maxDepth(root.right));
        }
    }
}
