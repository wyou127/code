package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: 9/26/14 3:31 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class LookAndSay {

    public String lookAndSay(String s) {
        int count = 0;
        char previousDigit = '\0';
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (previousDigit != s.charAt(i)) {
                if (count != 0) {
                    result.append(count);
                    result.append(previousDigit);
                }
                previousDigit= s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        result.append(count);
        result.append(s.substring(s.length()-1));
        return result.toString();
    }


    public void reverseLookAndSay(String s) {
        reverseLookAndSayHelper("",s);
    }

    public void reverseLookAndSayHelper(String prefix, String s) {

        if (s.length() ==1) {
            return;
        }  else if(s.length()==2|| s.length()==3 || oneDigit(s)) {
            System.out.println(prefix + expandString(s));
            return;
        } else if (s.length()==0) {
            System.out.println(prefix);
            return;
        } else{
            int count = 2;
            while (count <= s.length()) {
                reverseLookAndSayHelper(prefix + expandString(s.substring(0,count)), s.substring(count));
                count++;
            }
        }
    }

    public String expandString(String s) {
        int count = Integer.parseInt(s.substring(0,s.length()-1));
        StringBuilder sb = new StringBuilder();

        while (count>0){
            sb.append(s.charAt(s.length()-1));
            count--;
        }
        return sb.toString();
    }

    public boolean oneDigit(String s) {
        if (s.length()==0)
            return false;
        char previous = s.charAt(0) ;
        for (int i=0; i< s.length(); i++) {
            if (s.charAt(i)!=previous) {
                return false;
            }
            previous = s.charAt(i);
        }
        return true;
    }


    public static void main(String[] args) {
        LookAndSay lookAndSay = new LookAndSay();
        System.out.println(lookAndSay.lookAndSay("21"));

        lookAndSay.reverseLookAndSay("22221");
    }
}
