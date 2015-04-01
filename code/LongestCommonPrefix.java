package code;

/**
 * Created: 11/18/14 2:44 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length ==0) {
            return "";
        }
        String prefix = strs[0];         //a

        for (int i=1; i< strs.length; i++) {
            int j;
            for (j=0; j< Math.min(prefix.length(), strs[i].length()); j++) {
                if(prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            prefix = prefix.substring(0, j);
        }

        return prefix;

    }



    public static void main (String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        String[] strs = new String[] {"c", "c"};
        longestCommonPrefix.longestCommonPrefix(strs);
    }

}
