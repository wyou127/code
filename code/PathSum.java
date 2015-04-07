package code;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 * Created: 4/5/15 6:10 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSumHelper(root, sum);
    }


    public boolean hasPathSumHelper(TreeNode root, int sum) {
        if (root==null) {
            return false;
        }
        if (root.left ==null && root.right ==null) {
            return (sum==root.val);
        }
        else {
            sum -= root.val;
            return (hasPathSumHelper(root.left, sum) || hasPathSumHelper(root.right, sum));
        }
    }

}
