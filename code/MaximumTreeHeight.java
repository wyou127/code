package code;

/**
 * Created: 4/3/15 2:20 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class MaximumTreeHeight {
    private int max;
    private String maxPath;

    public int maxHeight(TreeNode treeNode, int level) {
        if (treeNode ==null) {
            return 0;
        } else {
            level = level++;
            return  Math.max(maxHeight(treeNode.right, level), maxHeight(treeNode.left, level));
        }
    }


    public void printMaxHeight(TreeNode treeNode, String path) {
        if (treeNode==null) {
            return;
        }
        path  = path + ""+ treeNode.val;
        if (treeNode.left == null || treeNode.right == null) {
            if (max < path.length()) {
                max = path.length();
                maxPath = path;
            }
        }
        printMaxHeight(treeNode.left, path);
        printMaxHeight(treeNode.right, path);

    }
}
