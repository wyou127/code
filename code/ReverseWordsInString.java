package code;

import java.util.Stack;

/**
 * Created: 8/20/14 2:10 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class ReverseWordsInString {
    public static void main(String[] args) {
        ReverseWordsInString r = new ReverseWordsInString();
        System.out.println(r.reverseWords("the sky is blue"));

    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = (words.length - 1); i >= 0; i--) {
            sb.append(words[i] + " ");

        }
        return sb.length() == 0 ? "" : sb.toString().substring(0, sb.length() - 1);
    }
}
