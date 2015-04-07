package code;

import java.util.Arrays;

/**
 * Created: 4/6/15 8:31 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (allNine(digits)) {
            int [] result = new int[digits.length + 1];
            Arrays.fill(result, 0);
            result[0]=1;
            return result;
        } else {
            boolean carryOver = true;
            int index = digits.length-1;
            while(carryOver) {
                if (digits[index]!=9) {
                    carryOver = false;
                    digits[index] ++;
                } else {
                    digits[index] =0;
                }
                index --;
            }
            return digits;
        }
    }

    public boolean allNine(int[] digits) {
        for (int i=0; i< digits.length; i++) {
            if (digits[i] != 9) {
                return false;
            }

        }
        return true;
    }
}
