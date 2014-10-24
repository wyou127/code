package code;

/**
 * Created: 9/4/14 11:21 AM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReOrderList {
    public void reorderList(ListNode head) {
        ListNode list1;
        ListNode list2;
        int length = 0;
        ListNode temp = head;
        while (temp.next!=null) {
            length++;
        }


    }

}
