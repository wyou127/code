package code;

import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]

 * Created: 4/2/15 3:16 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        /*
        for (int i=0; i<s.length(); i++) {
            for (int j=i+1; j<s.length(); j++) {
                if (isPalindrome(s.substring(i,j)) {

                }
            }
        }
            */
        return null;

    }

    public boolean isPalindrome(String s) {
        if (s.length()== 1)
            return true;

        int i=0;
        int j = s.length();

        while(i<j) {
            if (!(s.charAt(i) == s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
