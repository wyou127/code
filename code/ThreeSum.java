package code;

import java.util.*;

/**
 * Created: 11/18/14 4:05 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)

 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        for (int number: num) {
            if (map.containsKey(number)) {
                map.put(number, map.get(number)+1 );
            } else {
                map.put(number,1);
            }
        }

        for (int i=0; i< num.length; i++) {
            minusOne(map,num[i]);
            for (int j = i+1; j< num.length; j++) {
                minusOne(map, num[j]);

                int key =  -1 *(num[i] + num[j] );
                if (map.containsKey(key) && map.get(key) > 0) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]);
                    tmp.add(num[j]);
                    tmp.add(key);
                    Collections.sort(tmp);
                    result.add(tmp);
                }
               addOne(map, num[j]);
            }
            addOne(map, num[i]);
        }
        return result;
    }


    private void minusOne (Map<Integer, Integer> map, int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number)-1);
        }
    }

    private void addOne(Map<Integer, Integer> map, int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number)+1);
        }
    }



}
