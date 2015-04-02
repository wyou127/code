package code;

/**
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 *
 * Created: 4/2/15 3:08 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int result =0;
        for (int n : A) {
            result ^= n;
        }
        return result;
    }

}
