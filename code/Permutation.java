package code;

/**
 * Created: 9/23/14 6:59 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class Permutation {

    public void permutation(String s) {
        if (s==null) {
            return;
        }
        permutationHelper("", s);


    }

    public void permutationHelper(String prefix, String s) {
        if (s.length()==0) {
            System.out.println(prefix);
        } else {
            for(int i=0; i<s.length(); i++) {
                permutationHelper(prefix+s.charAt(i), s.substring(0,i) + s.substring(i+1));
            }
        }
    }

    public static void main(String[] args) {

        Permutation permutation = new Permutation();
        permutation.permutation("abc");
    }
}
