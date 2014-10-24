package code;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created: 10/14/14 3:14 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class MinHeap <T extends Comparable<T>>{

    class MyComparator implements Comparator<T>  {
        @Override
        public int compare(T t, T t2) {
            return t.compareTo(t2);
        }
    }

    PriorityQueue <T> minHeap;
    public MinHeap(int n) {
        minHeap = new PriorityQueue<T>(n, new MyComparator());
    }

    public static void main(String[]args) {
        MinHeap<Integer> minHeap = new MinHeap<Integer>(3);

        minHeap.minHeap.add(1);
        minHeap.minHeap.add(3);
        minHeap.minHeap.add(4);


        System.out.println(minHeap.minHeap.poll());

    }

}
