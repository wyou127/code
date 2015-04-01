package code;

/**
 * Created: 11/4/14 1:53 PM
 * Mirror flip binary tree
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class FlipBinaryTree {

    public void flip(TreeNode root) {

        if (root==null) {
            return;
        } else {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            flip(root.left);
            flip(root.right);
        }


    }
}
