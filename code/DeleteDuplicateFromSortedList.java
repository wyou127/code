package code;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.

 * Created: 4/6/15 8:11 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class DeleteDuplicateFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode node = head;

        while(node!=null) {
            ListNode tmp = node.next;
            while(tmp!=null && tmp.val == node.val) {
                tmp = tmp.next;
            }
            node.next = tmp;
            node = node.next;
        }

      return head;
    }
}
