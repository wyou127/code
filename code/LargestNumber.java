package code;

import java.util.*;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.


 * Created: 3/30/15 2:54 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class LargestNumber {
    public static class Card implements Comparable<Card>{
        int val;

        public String toString() {
            return "" + val;
        }

        public Card(int val) {
            super();
            this.val = val;
        }

        public int compareTo(Card o) {
            return this.val - o.val;
        }
    }

    public static String largestNumber2(int[] num) {

        if (num == null) {
            return null;
        }

        ArrayList<Card> list = new ArrayList<Card>();
        for (int n1: num) {
            list.add(new Card(n1));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Card n: list) {
            sb.append(n.toString());
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }

    public static String largestNumber(int[] num) {

        if (num == null) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int n1: num) {
            list.add(n1);
        }

        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                String s1 = "" + o1 + o2;
                String s2 = "" + o2 + o1;

                return s2.compareTo(s1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int n: list) {
            sb.append(n);
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}
