package code;

/**
 * Created: 10/13/14 4:20 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 * <p/>
 * <p/>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p/>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p/>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p/>
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (s.length() == 0) {
            return false;
        } else {
            int i=0;
            int j= s.length()-1;
            while(i<j) {
                char front = Character.toLowerCase(s.charAt(i));
                char end = Character.toLowerCase(s.charAt(j));
                if (!isAlphanumeric(front)){
                    i++;
                    continue;
                }
                if(!isAlphanumeric(end)){
                    j--;
                    continue;
                }
                if(front!=end) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }

    private boolean isAlphanumeric(char c) {
        return Character.isLetterOrDigit(c);
    }


    public static void main(String[]args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();

        String a= "race a car";
        System.out.println(validPalindrome.isPalindrome(a));

    }
}
