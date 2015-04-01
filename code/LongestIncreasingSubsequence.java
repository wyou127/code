package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created: 11/4/14 1:58 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 * <p/>
 * <p/>
 * Longest Increasing Subsequence (LIS) problem as an example problem that can be solved using Dynamic Programming.
 * The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence
 * such that all elements of the subsequence are sorted in increasing order. For example, length of LIS for
 * { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LongestIncreasingSubsequence {

    public int longestIncreasingSubsequence(int[] array) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        result.add(new ArrayList(Collections.singleton(array[0])));

        for (int i= 0; i< array.length; i++) {
            for (int j=0; j<i; j++) {
                if (array[i] > array[j] && result.get(i).size() < result.get(j).size()+1) {
                    result.remove(i);
                    result.add(result.get(j));
                }
            }
            List<Integer> list = result.remove(i);
            list.add(array[i]);
            result.add(list);
        }


        int max = 1;
        for (List<Integer> list: result) {
            max = Math.max(list.size(), max);
        }
        return max;
    }
}
