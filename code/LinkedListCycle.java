package code;

/**
 * Created: 9/15/14 3:37 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next ==null) {
            return false;
        }
        ListNode oneStep= head;
        ListNode twoStep = head.next;

        while(twoStep!=null) {
            if (twoStep.val == oneStep.val) {
                return true;
            }
            oneStep = oneStep.next;
            twoStep = twoStep.next;
            if (twoStep == null)
                return false;
            else
                twoStep = twoStep.next;
        }
        return false;
    }

    public static void main (String[] args) {
        ListNode seven = new ListNode(7);
        ListNode six = new ListNode(6, seven);
        ListNode five = new ListNode(5, six);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        //five = new ListNode(5, two);
        ListNode head = new ListNode(1, two);

        LinkedListCycle linkedListCycle = new LinkedListCycle();
        linkedListCycle.hasCycle(head);



    }
}
