/*
Merge Intervals Total Accepted: 15557 Total Submissions: 74613 My Submissions
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        for (Interval newInterval : intervals) {
            result = insert(result, newInterval);
        }
        
        return result;
    }
    
    private List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        
        int pos = 0;
        List<Interval> result = new ArrayList<Interval>();
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
                pos++;
            } else if (newInterval.end < interval.start) {
                result.add(interval);
            } else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        
        result.add(pos, newInterval);
        return result;
    }
}