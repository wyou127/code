package code;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p/>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p/>
 * Created: 4/5/15 6:40 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
        if (diff <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }


    public boolean checkBinaryTreeIsBalanced(TreeNode root){

        if(computeAndCheckHeight(root) == -1)
            return false;
        else
            return true;
    }

    public int computeAndCheckHeight(TreeNode root){
     /* Base case - Tree is empty */
        if(root == null)
            return 0;
     /* Height of left subtree */
        int leftSubTreeHeight = computeAndCheckHeight(root.left);
     /* Left subtree is not balanced */
        if(leftSubTreeHeight == -1)
            return -1;

     /* Height of right subtree */
        int rightSubTreeHeight = computeAndCheckHeight(root.right);
     /* Right subtree is not balanced */
        if(rightSubTreeHeight == -1)
            return -1;

     /* Difference in height */
        int heightDifference = Math.abs(leftSubTreeHeight - rightSubTreeHeight);
     /* Root node is not balanced */
        if(heightDifference > 1)
            return -1;
        else
          /* Height of the root node */
            return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
    }
}
