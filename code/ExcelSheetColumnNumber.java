package code;

/**
 * Created: 2/4/15 3:54 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        final int interval = 26;
        int number = 0;
        int times =0;


        for (int i=s.length()-1; i>=0; i--) {
            char n = s.charAt(i);
            int factor = (n - 'A') + 1;
            double  power = Math.pow(interval, times);
            number = number + factor * (int)power;
            times ++;
        }

       return number;
    }

    public static void main(String[] args) {

        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        excelSheetColumnNumber.titleToNumber("AAA");
    }
}
