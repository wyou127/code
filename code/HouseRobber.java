package code;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money
 you can rob tonight without alerting the police.

 // rob[i] = max (rob[i-2], rob[i-3]);

 * Created: 3/31/15 9:49 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class HouseRobber {
    public int rob(int[] num) {
        int [] max = new int[num.length];

        max[0] = num[0];
        max[1] = Math.max(num[1], num[0]);
        max[2] = Math.max((max[0] + num[2]), max[1]);

        for (int i= 3; i< num.length; i++) {
            max[i] = num[i] + Math.max(max[i-2], max[i-3]);
        }

        return max[num.length-1];

    }




}
