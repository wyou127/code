package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: 11/5/14 4:54 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
class Parlindrome {

    public List<String> getParlindome(String[] array) {

        List<String> result = new ArrayList<String>();
        for (String s : array) {
            if (isParlindome(s)) {
                result.add(s);
            }
        }
        return result;
    }

    public boolean isParlindome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!(s.charAt(i) == s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;


    }


    public static void main(String[] args) {
        Parlindrome p = new Parlindrome() ;

        String[] array = new String[]{"madam", "nope", "rotor", "hmmmm"} ;
        List <String> result = p.getParlindome(array);
        System.out.print(result.toString());

    }
}