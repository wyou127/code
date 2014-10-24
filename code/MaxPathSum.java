package code;

/**
 * Created: 10/13/14 4:40 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 *
 * Given a binary tree, find the maximum path sum.

 The path may start and end at any node in the tree.

 For example:
 Given the below binary tree,
 */
public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        if (root==null)  {
            return 0;
        } else {
            return Math.max(1+maxPathSum(root.left), 1+maxPathSum(root.right));
        }
    }
}
