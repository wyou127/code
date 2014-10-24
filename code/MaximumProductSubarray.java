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
        if (A.length == 1) {
            return A[0];
        }
        int positiveMax =A[0];
        int negativeMax =Integer.MIN_VALUE;
        int result=1;

        for (int i =0; i< A.length; i++) {
            if (A[i]!=0) {
                result = result * A[i];
                if (result > 0) {
                    positiveMax = positiveMax>result?positiveMax:result;
                }  else {
                    negativeMax = negativeMax<result?negativeMax:result;
                    result = 1;
                }
            } else {
                result = 1;
                positiveMax = positiveMax>A[i]?positiveMax:A[i];
            }
        }
        return positiveMax;
    }


    public int maxProduct2(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int maxherepre = A[0];
        int minherepre = A[0];
        int maxsofar = A[0];
        int maxhere, minhere;

        for (int i = 1; i < A.length; i++) {
            maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
            minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
            maxsofar = Math.max(maxhere, maxsofar);
            maxherepre = maxhere;
            minherepre = minhere;
        }
        return maxsofar;
    }

    public static void main(String[]args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int[]A = {3,0,4};
        System.out.println(maximumProductSubarray.maxProduct2(A));

    }
}
