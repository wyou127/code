package code;

/**
 * Created: 10/2/14 2:01 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p/>
 * Assume a BST is defined as follows:
 * <p/>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        else if (root.left == null && root.right != null) {
            if ((root.val < root.right.val) && (root.right.val < max) && isValidBST(root.right, root.val, max))
                return true;
            else return false;
        } else if (root.right == null && root.left != null) {
            if ((root.left.val < root.val) && (min < root.left.val) && isValidBST(root.left, min, root.val))
                return true;
            else return false;
        } else {
            if ((root.val < root.right.val) && (root.right.val < max) && isValidBST(root.right, root.val, max)
                    && (root.left.val < root.val) && (min < root.left.val) && isValidBST(root.left, min, root.val))
                return true;
            else
                return false;
        }
    }
}