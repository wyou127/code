package code;

/**
 * Created: 10/1/14 11:20 AM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 * <p/>
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class SortedListToBinaryTree {
    public TreeNode sortedListToBST(ListNode head) {
        int length = countLength(head);
        return sortedListToBSTHelper(head, length);

    }


    public TreeNode sortedListToBSTHelper(ListNode head, int length) {
        if (length == 0)
            return null;
        if (length == 1)
            return new TreeNode(head.val);
        else {
            ListNode current = head;
            int count = 0;
            while (count < (length / 2)) {
                current = current.next;
            }

            TreeNode root = new TreeNode(current.val);
            current = current.next;
            TreeNode leftNode = sortedListToBSTHelper(head, length/2);
            TreeNode rightNode = sortedListToBSTHelper(current, length- (length/2) -1);

            root.left = leftNode;
            root.right = rightNode;
            return root;
        }
    }

    public int countLength(ListNode head) {
        int length = 0;
        ListNode current = head;

        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }
}
