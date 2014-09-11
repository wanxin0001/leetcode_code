import java.util.*;
public class Solution {
    private static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
       Point(int a, int b) { x = a; y = b; }
    }
    public static void main(String[] str) {
        Solution obj = new Solution();
        Point[] points = new Point[3];
        points[0] = new Point(2,3);
        points[1] = new Point(3,3);
        points[2] = new Point(-5,3);
        System.out.println(obj.maxPoints(points));

    }
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
                    double k = (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x);
                    System.out.println("111");
                    System.out.println(k);
                    if (map.containsKey(k)) {
                        map.put(k, map.get(k) + 1);
                        System.out.println("222");
                    } else {
                        map.put(k, 2);
                    }
                }
                
               
                
                
            }
             for (int item : map.values()) { // it calls values()
                    System.out.println(item + " "+dup);
                    if (max < item + dup) {
                        max = item + dup;
                    }
                }
            
            
        }
        return max;
    }
}