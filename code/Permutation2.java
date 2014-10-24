package code;

import java.util.HashSet;
import java.util.Set;

/**
 * Created: 9/23/14 9:33 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class Permutation2 {

    public void permutation(String s) {
        if (s == null) {
            return;
        }
        permutationHelper("", s);


    }

    public void permutationHelper(String prefix, String s) {
        if (s.length() == 0) {
            System.out.println(prefix);
        } else {
            Set<Character> set = new HashSet<Character>();
            for (int i = 0; i < s.length(); i++) {
                char anchor = s.charAt(i);
                if (!set.contains(anchor)) {
                    set.add(anchor);
                    permutationHelper(prefix + anchor, s.substring(0, i) + s.substring(i+1));
                }
            }
        }
    }
    public static void main(String[] args) {

        Permutation2 permutation2 = new Permutation2();
        permutation2.permutation("abcb");
    }
}
