package code;

/**
 * Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37

 * Created: 3/31/15 8:57 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int count = Math.max(v1.length, v2.length);

        for (int i=0; i<count; i++) {
            int n1 = Integer.parseInt(v1.length > i ? v1[i] : "0");
            int n2 = Integer.parseInt(v2.length>i ? v2[i] : "0");

            if (n1>n2) {
                return 1;
            } else if (n1 < n2) {
                return -1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {

        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();

        compareVersionNumbers.compareVersion("1","0");
    }

}
