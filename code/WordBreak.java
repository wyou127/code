package code;

import java.util.Set;

/**
 *
 * possible[i] = true      if  S[0,i]在dictionary里面

                = true      if   possible[k] == true 并且 S[k+1,j]在dictionary里面， 0<k<i

                = false      if    no such k exist
 * Created: 4/5/15 2:10 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        String s2 = '#' + s;
        int len = s2.length();
        boolean[] possible = new boolean[len];

        possible[0] = true;
        for (int i = 1; i < len; ++i) {
            for (int k = 0; k < i; ++k) {
                possible[i] = possible[k] && dict.contains(s2.substring(k + 1, i - k));
                if (possible[i]) break;
            }
        }
        return possible[len - 1];
    }
}
