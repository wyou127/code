package code;

/**
 * Created: 11/16/14 2:49 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 * <p/>
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * <p/>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int start = 0;
        int end = A.length;
        while (start < end) {
            if (A[start] == elem) {
                while(end>start) {
                    if (A[end-1] !=elem) {
                        A[start] = A[end - 1];
                        break;
                    } else {
                        end--;
                    }
                }
                if (end == start) {
                    return start;
                }
                end--;
                start++;
            } else {
                start++;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] A = new int[] {4,5};
        System.out.println(removeElement.removeElement(A,4));

    }
}
