package code;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.

 * Created: 3/31/15 9:34 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int c1 =getLength(headA);
        int c2 =getLength(headB);

        ListNode longer = c1>c2 ? headA : headB;
        ListNode shorter = c1>c2 ? headB : headA;


        int diff = Math.abs(c1-c2);

        while (diff>0) {
            longer = longer.next;
            diff --;
        }

        int min = Math.min(c2, c1);

        while(min>0) {
            if (shorter.val== longer.val){
                return shorter;
            } else {
                shorter = shorter.next;
                longer = longer.next;
            }
            min--;
        }

        return null;

    }


    private int getLength(ListNode head) {
        int count = 0;
        ListNode current = head;
        while(current!=null) {
            count++;
            current = current.next;
        }

        return count;
    }


    public static void main(String[] args) {
        ListNode b =  new ListNode(2);
        ListNode a = new ListNode(1,b);

        IntersectionOfTwoLinkedList intersectionOfTwoLinkedList = new IntersectionOfTwoLinkedList();
        intersectionOfTwoLinkedList.getIntersectionNode(a,b);



    }
}
