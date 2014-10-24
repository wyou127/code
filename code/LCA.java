package code;

/**
 * Created: 10/1/14 10:43 AM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class LCA {

    /**
     * Binary Search tree
     */
    public TreeNode findBSTLCA(TreeNode root, int n1, int n2) {
        if (root == null) {
            return null;
        } else if (root.val > n1 && root.val > n2) {
            return findBSTLCA(root.left, n1,n2);
        } else if (root.val < n1 && root.val < n2) {
            return findBSTLCA(root.right, n1,n2);
        } else {
            return root;
        }
    }

    /**
     * Binary tree
     */
    public TreeNode findLCA(TreeNode root, int n1, int n2) {
        if (root==null) {
            return null;
        } else if (root.val==n1 || root.val==n2) {
            return root;
        } else {
           TreeNode l = findLCA(root.left, n1, n2);
           TreeNode r = findLCA(root.right, n1, n2);
           if (l!=null && r!=null) {
               return root;
           } else {
               return l==null?r:l;
           }
        }
    }
}

