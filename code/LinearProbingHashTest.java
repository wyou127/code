package code;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created: 10/15/14 3:23 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */

public class LinearProbingHashTest {

    @Test
    public void testLinearProbingHashTestPutNGet() {
        LinearProbingHash linearProbingHash = new LinearProbingHash(5);
        linearProbingHash.put(2);
        linearProbingHash.put(7);
        linearProbingHash.put(3);
        linearProbingHash.get(3);

        Assert.assertEquals(linearProbingHash.get(3).intValue(), Integer.parseInt(linearProbingHash.array[3]));
        Assert.assertEquals(linearProbingHash.get(4).intValue(), 8) ;

        int [] array = new int[]{1,2,3};
    }

}
