package code;

import java.util.Stack;

/**
 * Created: 2/4/15 3:26 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 *
 * Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"

 corner case //
 corner case /
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String> ();

        String[] array = path.split("/");
        int count = 0;

        for (int i=0; i<array.length; i++) {
            if(!(array[i].equals(".") ||  array[i].equals(""))) {
                if (array[i].equals("..")) {
                    if(stack.size()>0)
                        stack.pop();
                } else {
                    stack.add(array[i]);
                }
            }
        }

        if (stack.size()==0)
            return "/";

        String newPath = "";

        for(String s : stack) {
            newPath = newPath + "/" + s;
        }

        return newPath;

    }
}
