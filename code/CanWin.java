package code;

import java.util.HashSet;
import java.util.Set;

/**
 * Created: 9/25/14 11:09 AM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class CanWin {

    public boolean canWin(int[] array, int index) {
        Set<Integer> visited = new HashSet<Integer>();
        if (array ==null) {
            return false;
        } else return canWinHelper(array, index, visited);

    }
    public boolean canWinHelper(int[] array, int index, Set<Integer> parentVisited) {
        Set<Integer>  visited = parentVisited;
        if(array[index] ==0) {
            return true;
        }
        if (index <0 || index > array.length-1){
            return false;
        }
        if (visited.contains(index)) {
            return false;
        } else {
            visited.add(index);
            return canWinHelper(array, index+array[index], visited) || canWinHelper(array,index-array[index], visited);
        }
    }

}
