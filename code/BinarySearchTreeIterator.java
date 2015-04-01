package code;

import java.util.Iterator;
import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.



 * Created: 3/30/15 3:42 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class BinarySearchTreeIterator implements Iterator<TreeNode>{
    private TreeNode node;
    public Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        this.node = root;
        stack = new Stack<TreeNode>();
        while(root!=null) {
            stack.add(root);
            root = root.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public TreeNode next() {
        TreeNode current = stack.pop();
        TreeNode right = current.right;
        while (right!=null) {
            stack.add(right);
            right = right.left;
        }

        return current;
    }

    @Override
    public void remove() {

    }
}
