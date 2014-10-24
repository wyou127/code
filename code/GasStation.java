package code;

/**
 * Created: 9/25/14 6:08 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int totalGas = 0;
        int totalCost = 0;
        for (int i=0; i<gas.length; i++) {
            sumGas = sumGas + gas[i];
            sumCost = sumCost + cost[i];
            if (sumGas < sumCost) {
                sumGas = 0;
                sumCost = 0;
                start = i +1;
            }
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas<totalCost) {
            return -1;
        }
        return start;
    }


    public static void main(String[]args) {
        int[] gas = {1,2,3,4,5};
        int []cost = {3,4,5,1,2};

        GasStation gasStation = new GasStation();
        System.out.println(gasStation.canCompleteCircuit(gas, cost));
    }
}
