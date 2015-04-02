package code;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * <p/>
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * <p/>
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p/>
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * <p/>
 * <p/>
 * Created: 4/1/15 2:41 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class WordLadder {
    public int ladderLength1(String start, String end, Set<String> dict) {
        List<Integer> result = new ArrayList<Integer>();
        Set<String> visited = new HashSet<String>();
        visited.add(start);
        ladderLengthHelper(start, end, dict, 1, result, visited);

        if (result.isEmpty())
            return 0;

        int min = Integer.MAX_VALUE;
        for (int n : result) {
            min = Math.min(n, min);
        }
        return min;
    }

    public void ladderLengthHelper(String start, String end, Set<String> dict, int step, List<Integer> result, Set<String> visited) {
        Set<String> newVisited = new HashSet<String>(visited);
        if (start.equals(end)) {
            result.add(step);
        } else {
            for (int i = 0; i < start.length(); i++) {
                for (char c = 'a'; c < 'z'; c++) {
                    String newStr = start.substring(0, i) + c + start.substring((i + 1));
                    if (!newVisited.contains(newStr) && dict.contains(newStr)) {
                        newVisited.add(newStr);
                        ladderLengthHelper(newStr, end, dict, step + 1, result, newVisited);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        Set<String> set = new HashSet<String>();
        //["hot","dog","dot"]
        /*set.add("hot");
        set.add("dog");
        set.add("dot");
        */


        set.add("a");
        set.add("b");
        set.add("c");

        wordLadder.ladderLength("a", "c", set);

    }


    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict == null)
            return 0;
        Queue<String> queue = new LinkedList<String>();

        queue.add(start);
        dict.remove(start);
        int step = 1;

        while (!queue.isEmpty()) {
            int level_count = queue.size();

            for (int i = 0; i < level_count; i++) {
                String s = queue.poll();

                for (int j = 0; j < s.length(); j++) {
                    for (char c = 'a'; c < 'z'; c++) {
                        String newStr = s.substring(0, j) + c + s.substring(j + 1);
                        if (newStr.equals(end)) {
                            return step + 1;
                        } else {
                            if (dict.contains(newStr)) {
                                queue.add(newStr);
                                dict.remove(newStr);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }

}
