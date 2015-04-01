package code;


import java.util.*;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 * Created: 3/30/15 10:25 AM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> set = new HashSet<Integer>();
        List<String> result = new ArrayList<String>();
        for (int i=10 ; i< s.length(); i++) {
            String subString = s.substring(0,i);
            if (set.contains(convert(subString))) {
                result.add(s.substring(0,i));
            }  else{
                set.add(convert(subString));
            }
        }
        return result;
    }

    public int convert(char c) {
        switch (c) {
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            case 'T':
                return 4;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int convert (String s) {
        int result = 0;
        for(int i =0; i< s.length(); i++)  {
            int cur = convert(s.charAt(i));
            result = result + cur *4;
            result *= 4;
        }
        return result;
    }

}
