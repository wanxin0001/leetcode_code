/*
Simplify Path Total Accepted: 11566 Total Submissions: 57953 My Submissions
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/
public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return null;
        }
        
        String[] array = path.split("/");
        Stack<String> stack = new Stack<String>();
        
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals("")) {
                if (array[i].equals("..")) {
                    if (stack.size() != 0) {
                        stack.pop();
                    }
                } else if (array[i].equals(".")) {
                    continue;
                } else {
                    stack.push(array[i]);
                }
            }
        }
        String result = "/";
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            result = "/" + stack.pop()  + result;
        }
        if (!result.equals("/")) { //Important!!!!
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}