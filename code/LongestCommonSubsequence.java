package code;

/**
 * Created: 11/6/14 4:27 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class LongestCommonSubsequence {
    public int lcs(String s1, String s2) {
        int [][] matrix = new int[s1.length()+1][s2.length()+1];

        for (int i= 0; i<= s1.length(); i++) {
            for (int j=0; j<=s2.length(); j++) {
                if (i==0 || j==0) {
                    matrix[i][j] = 0;
                } else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1]+1;
                } else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }
        return matrix[s1.length()][s2.length()];
    }


    public static void main(String[]args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.lcs("ABCD", "CABCDE"));
    }
}
