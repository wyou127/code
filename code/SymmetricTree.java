package code;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p/>
 * For example, this binary tree is symmetric:
 * <p/>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Created: 4/6/15 4:08 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }if (root.left==null ) {
            return (root.right == null);
        } else if (root.right ==null) {
            return false;
        } else {
            if (root.left.val == root.right.val) {
                return isSymmetric(root.left) && isSymmetric(root.right);
            }
            return false;
        }
    }


    public boolean isSymmetric2(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return true;
        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode a, TreeNode b){
        if(a==null) return b==null;
        if(b==null) return false;

        if(a.val!=b.val) return false;

        if(!isSymmetric(a.left,b.right)) return false;
        if(!isSymmetric(a.right,b.left)) return false;

        return true;
    }
}
