/*
Max Points on a Line Total Accepted: 18785 Total Submissions: 171364 My Submissions
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Have you been asked this question in an interview? 
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            map.clear(); // very important
            
            map.put((double) Integer.MIN_VALUE, 1); //Must have double
            int dup = 0;
            for (int j = i + 1; j < points.length; j++) {
                
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup++;
                    continue;
                } else if (points[i].x == points[j].x) {
                    map.put((double)Integer.MIN_VALUE, map.get((double)(Integer.MIN_VALUE)) + 1);
                } else {
                    double k = 0.0 + (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x); //Must add 0.0
                    if (map.containsKey(k)) {
                        map.put(k, map.get(k) + 1);
                    } else {
                        map.put(k, 2);
                    }
                }
                
               
                
                
            }
             for (int item : map.values()) { // it calls values()
                    if (max < item + dup) {
                        max = item + dup;
                    }
                }
            
            
        }
        return max;
    }
}