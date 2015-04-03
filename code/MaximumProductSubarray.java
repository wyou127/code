package code;

/**
 * Created: 9/25/14 11:49 AM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4,-3],
 the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int maxherepre = A[0];
        int minherepre = A[0];
        int maxhere, minhere;

        int maxsofar = A[0];

        for (int i = 1; i < A.length; i++) {
            maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
            minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
            maxsofar = Math.max(maxhere, maxsofar);
            maxherepre = maxhere;
            minherepre = minhere;
        }
        return maxsofar;
    }


    public int maxProduct3(int[] A) {
        int max = Integer.MIN_VALUE;
        int current = 1;

        for (int n : A) {
            current = current * n;
            max = Math.max(max, current);
            if (current ==0) {
                current =1;
            }
        }
        return max;
    }

    public int maxProduct2(int[] A) {
        int maxpre = A[0];
        int minpre = A[0];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int result = A[0];

        for (int i=1; i<A.length; i++) {
            max = Math.max(Math.max(maxpre * A[i], minpre*A[i]), A[i]);
            min = Math.min(Math.min(maxpre * A[i], minpre * A[i]), A[i]);
            result = Math.max(max, result);
            maxpre = max;
            minpre = min;
        }
        return result;

    }

    public static void main(String[]args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int[]A = {3,0,4};
        System.out.println(maximumProductSubarray.maxProduct(A));

    }
}
