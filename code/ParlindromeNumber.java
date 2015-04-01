package code;

/**
 * Created: 11/18/14 2:58 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class ParlindromeNumber {
    public boolean isPalindrome(int x) {
        if (x <0) {
            return false;
        }

        // get the digit count
        int length = (int) Math.log10(x) + 1;

        int low_digit_mod= 10;
        int high_digit_mod = (int)(1* Math.pow(10, length-1));

        int i = 0;
        int j = length-1;

        while(i<j) {
            int low = (x % low_digit_mod) / (low_digit_mod/10);
            int high = (x / high_digit_mod) % 10;

            if (low!=high) {
                return false;
            }

            low_digit_mod = low_digit_mod * 10;
            high_digit_mod = high_digit_mod / 10;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        ParlindromeNumber parlindromeNumber = new ParlindromeNumber();
        System.out.println(parlindromeNumber.isPalindrome(19354391));
    }
}
