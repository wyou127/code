package code;

/**
 * Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

 * Created: 4/6/15 4:59 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q){
        if (p ==null && q==null) {
            return true;
        } else if (p==null) {
            return (q==null);
        } else if (q==null) {
            return false;
        }  else {
            if (q.val == p.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
            return false;
        }
    }
}
