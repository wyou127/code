package code;

/**
 * Created: 3/26/15 4:43 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 *
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.


 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int length = nums.length;

        k = k % length;
        for (int i=0; i< length-k; i++) {
            //swap(i,i+k);
            int tmp = nums[i];
            nums[i] = nums[i+k];
            nums[i+k] = tmp;
        }
    }




}
