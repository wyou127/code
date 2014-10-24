package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: 10/2/14 2:58 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

/**
 *
 * NOTE THE newPrefix. if inplace update the prefix, it will cause the next recursive using the previous result.
 *
 *
 */
public class RestoreIPAddress {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        restoreIpAddressesHelper("", s, result);
        return result;
    }

    public void restoreIpAddressesHelper(String prefix, String s, List<String> result) {
        int segment = prefix.split("\\.").length;
        if(s.length()==0 && segment==4) {
            result.add(prefix);
            return;
        } else if ((segment==4 && s.length()!=0 || s.length()==0 &&segment!=4)) {
            return;
        } else {
            int count = Math.min(s.length(),3);
            if (s.charAt(0)!='0') {
                for (int i = 1; i <= count; i++) {
                    String newPrefix;
                    int number = Integer.parseInt(s.substring(0, i));
                    if (number < 256) {
                        if (prefix.length()==0){
                            newPrefix = ""+number;
                        } else {
                            newPrefix = prefix + "." + number;
                        }
                        restoreIpAddressesHelper(newPrefix, s.substring(i), result);
                    }
                }
            } else {
                String newPrefix;
                if (prefix.length()==0){
                    newPrefix = ""+'0';
                } else {
                    newPrefix = prefix + "." + '0';
                }
                restoreIpAddressesHelper(newPrefix, s.substring(1), result);
            }
        }
    }

    public static void main(String [] args) {
        RestoreIPAddress restoreIPAddress = new RestoreIPAddress();
        restoreIPAddress.restoreIpAddresses("0000");
    }
}

