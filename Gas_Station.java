/*
Gas Station Total Accepted: 19340 Total Submissions: 75214 My Submissions
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.


*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
            return -1;
        }
        
        int[] map = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            map[i] = gas[i] - cost[i];
        }
        int sum = 0;
        int index = -1;
        int total = 0;
        for (int i = 0; i < map.length; i++) {
            sum += map[i];
            total += map[i];
            if (sum < 0) {
                index = i;
                sum = 0;
            }
        }
        
        if (total >= 0) {
            return index + 1;
        } else {
            return -1;
        }
    }
}