package code;

/**
 * Created: 10/4/14 10:03 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class TryCatch {

    public static void main(String[] args) {
        int[] a = {5};

        try {
            System.out.print(a[2]);
        }catch (Exception e){

        }

        System.out.println("after");
    }
}
