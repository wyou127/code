package code;

/**
 * Created: 3/30/15 4:02 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 * <p/>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p/>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    public int majorityElement(int[] num) {
        int count = 1;
        int index = 0;

        for (int i = 1; i < num.length; i++) {
            if (count > 0) {
                if (num[i] == num[index]) {
                    count++;
                } else {
                    count--;
                }
            } else {
                index = i;
                count = 1;
            }
        }

        int final_count = 0;

        for (int n : num) {
            if (n == num[index]) {
                final_count++;
            }
        }

        if (final_count > num.length / 2) {
            return index;
        } else {
            return -1;
        }

    }
}
