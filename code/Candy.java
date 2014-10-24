package code;

/**
 * Created: 9/25/14 2:31 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 *
 * There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 */
public class Candy {

    public int candy(int[] ratings) {

        int count =0;

        if (ratings==null)
            return 0;
        boolean increase = false;
        int [] candyArray = new int[ratings.length];
        int previous = Integer.MAX_VALUE;

        for(int i=0; i<ratings.length; i++) {
            increase = (ratings[i] > previous);
            previous = ratings[i];
            if(increase) {
                candyArray[i] = candyArray[i-1] +1;
            } else {
                candyArray[i] = 1;
            }
        }

        previous = Integer.MAX_VALUE;
        for (int i = ratings.length-1; i >=0; i--) {
            increase = (ratings[i]>previous);
            previous = ratings[i];
            if(increase && candyArray[i]<=candyArray[i+1]) {
                candyArray[i] = candyArray[i+1] +1;
            }
            count = count+ candyArray[i];
        }
        return count;
    }


    public static void main (String []args) {
        Candy candy = new Candy();
        int[] ratings = {4,2,3,4,1};
        System.out.println(candy.candy(ratings));
    }
}
