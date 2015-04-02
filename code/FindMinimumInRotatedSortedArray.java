package code;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.

 * Created: 4/1/15 1:19 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class FindMinimumInRotatedSortedArray {
    //binary search

    public int findMin(int[] num) {
        return findMinHelper(num, 0, num.length-1);
    }

    public int findMinHelper(int[] num, int low, int high) {
        if (high < low)  return num[0];
        if (high == low) return num[low];

        int mid = (high+low)/2;

        // Check if mid+1 is minimum element
        if (mid < high && num[mid+1] < num[mid])
            return num[mid+1];

        // Check if mid itself is minimum element
        if (mid > low && num[mid] < num[mid - 1])
            return num[mid];

        if (num[high] > num[mid]) {
             return findMinHelper(num, low, mid-1);
        } else {
             return findMinHelper(num, mid+1, high);
        }
    }

    public int findMin2(int[]num)
    {
        int low =0;
        int high = num.length-1;
        while (num[low] > num[high])
        {
            // find mid.
            int mid = (low + high)/2;
            // decide which sub-array to continue with.
            if (num[mid] > num[high])
                low = mid + 1;
            else
                high = mid;
        }
        return num[low];
    }

}
