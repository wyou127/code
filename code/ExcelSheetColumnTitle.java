package code;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB

 *
 * Created: 3/31/15 2:11 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        String result = "";

        while(n>0) {
            int digit = n % 26;
            n = n / 26;
            if (digit == 0) {
                result = 'Z' + result;
                n--;
            } else {
                result = (char)('A' + digit - 1) + result;
            }
        }

        return result;
    }

}
