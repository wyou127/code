package code;

/**
 * Created: 2/4/15 4:16 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 * <p/>
 * Implement int sqrt(int x).
 * <p/>
 * Compute and return the square root of x.
 */
public class SquareRoot {
    public int sqrt(int n) {

        double x = n;
        double y = 1;
        double e = 0.0000000001; /* e decides the accuracy level*/
        while (x - y >= e) {
            x = y + (x - y) / 2;
            y = n / x;
        }
        return (int) (x);
    }

    public int sqrt2(int x) {
        if( x == 0 || x == 1){
            return x;
        }
        long start = 0;
        long end = x;


        while ( end-start > 1){
            long mid = (int)(end + start) / 2;
            long s = mid * mid;

            if(s == x){
                return (int)mid;
            }
            else if(s > x){
                end = mid;
            }
            else {
                start = mid;
            }

        }

        return (int)start;
    }

}
