package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created: 9/16/14 10:30 AM
 *
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].

 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> list  = new ArrayList<String>();
        if(s==null || s.length()==0)
            return list;
        wordBreakHelper(s,dict,"",list);
        return list;
    }

    public void wordBreakHelper (String s, Set<String> dict, String result, List<String> list) {
        if(s==null) {
            list.add(result);
        } else {
            for (int i=0; i<s.length(); i++) {
                if (dict.contains(s.substring(0,i))) {
                    wordBreakHelper(s.substring(i + 1), dict, result + " " + s.substring(0, i), list);
                }
            }
        }

    }

}
