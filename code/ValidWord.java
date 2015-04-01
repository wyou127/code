package code;

import java.util.HashSet;
import java.util.Set;

/**
 * Created: 10/31/14 12:44 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class ValidWord {


    public void validList(String s, Set<String> dict) {
        validListHelper("", s, dict);
    }


    private void validListHelper(String prefix, String s, Set<String> dict) {
        if (s.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i <= s.length(); i++) {
                if (dict.contains(s.substring(0, i))) {
                    String newPrefix = prefix + s.substring(0, i) + " ";
                    String newString = s.substring(i);

                    validListHelper(newPrefix, newString, dict);
                } else {
                    if (i == s.length())
                        return;
                }
            }
        }

    }

    public static void main(String[] args) {

        String s = "hellopen";

        Set<String> dict = new HashSet<String>();

        dict.add("hell");

        dict.add("open");

        dict.add("hello");

        dict.add("pen");

        ValidWord validWord = new ValidWord();
        validWord.validList(s, dict);

    }


}
