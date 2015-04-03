package code;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p/>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p/>
 * Find the total sum of all root-to-leaf numbers.
 * <p/>
 * For example,
 * <p/>
 * 1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * <p/>
 * Return the sum = 12 + 13 = 25.
 * <p/>
 * <p/>
 * Created: 4/2/15 4:28 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        int prev =0;
        return subNumbers(root, prev);
    }

    public int subNumbers(TreeNode root, int prev) {
        if (root ==null)
            return 0;
        prev = prev *10 + root.val;
        if (root.left == null && root.right ==null) {
            return prev;
        }  else {
            return subNumbers(root.left, prev) + subNumbers(root.right,prev);
        }
    }
}