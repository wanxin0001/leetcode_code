/*
Candy Total Accepted: 17655 Total Submissions: 93005 My Submissions
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/

public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        
        if (ratings.length == 1) {
            return 1;
        }
        
        int len = ratings.length;
        int[] array = new int[len];
        array[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                array[i] = array[i - 1] + 1;
            } else {
                array[i] = 1;
            }
        }
        
        for (int i = len - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                if (array[i] >= array[i - 1] ) {
                    array[i - 1] = array[i] + 1;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += array[i];
        }
        
        return sum;
    }
}