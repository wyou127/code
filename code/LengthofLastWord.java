package code;

/**
 * Created: 3/27/15 5:15 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class LengthofLastWord {

    public int lengthOfLastWord(String s) {
        int count =0;
        boolean spaceFlag = true;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) ==' ') {
                spaceFlag = true;
            } else {
                if (spaceFlag) {
                    count = 1;
                    spaceFlag = false;
                }  else {
                    count++;
                }
            }

        }
        return count;

    }
}
