package code;

/**
 * Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.

 * Created: 3/30/15 3:49 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class FactorialTrailingZero {
    public int trailingZeroes(int n) {
        int count = 0;
        int k = 5;
        while(n >= k)
        {
            count+=n/k;
            k*=5;
        }
        return count;

    }

}
