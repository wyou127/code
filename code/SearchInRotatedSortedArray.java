package code;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).        6 7 0 1 2 3 4 5

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 * Created: 10/31/14 11:25 AM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class SearchInRotatedSortedArray {

    public int search(int[] A, int target) {
        return binarySearch(A, target, 0, A.length-1);

    }

    private int binarySearch(int[]A, int target, int start, int end) {

        if (end < start)
            return -1;
        int mid = start + (end - start)/2;

        if (A[target] == A[start]) {
            return start;
        }
        if (A[target] == A[end]) {
            return end;
        }
        if (A[target] == A[mid]) {
            return mid;
        }

        if (A[mid] > A[start]) {
            if (A[target] > A[start] && A[target] < A[mid]) {
                return  binarySearch(A, target, start, mid-1 );
            }
            else {
                return binarySearch(A, target, mid+1, end);
            }
        }  else {
            if (A[mid]<A[target] && A[target] < A[end]) {
                return binarySearch(A, target, mid+1, end);
            } else {
                return binarySearch(A, target, start, mid-1);
            }
        }

    }


}
