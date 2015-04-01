package code;

/**
 * Created: 11/16/14 3:17 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 *
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array A = [1,1,2],

 Your function should return length = 2, and A is now [1,2].

 */
public class RemoveDuplicatesFromArray {

    // iterator i
    // new swap candidate;
    // if i is the new number  swap with length
    // length ++;
    // return length;
    public int removeDuplicates(int[] A) {

        if (A.length==0) {
            return 0;
        }

        int length =1;
        int previous = A[0];
        boolean swap = false;

        for (int i=1; i< A.length; i++) {
            if (previous != A[i]) {
                if (swap) {
                    A[length] = A[i];
                }
                length ++;
            } else {
                swap = true;
            }
            previous = A[i] ;
        }
        return length;

    }


    public static void main(String[]args) {
        RemoveDuplicatesFromArray removeDuplicatesFromArray = new RemoveDuplicatesFromArray();
        int []A = new int[] {1,1,2,3};

        System.out.println(removeDuplicatesFromArray.removeDuplicates(A));
    }



}
