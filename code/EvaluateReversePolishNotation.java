package code;

import java.util.*;

/**
 * Created: 8/21/14 2:05 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class EvaluateReversePolishNotation {
    private static Set<Character> operatorSet = new HashSet<Character>();
    static {
        operatorSet.add('+');
        operatorSet.add('-');
        operatorSet.add('*');
        operatorSet.add('/');
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i=0; i< tokens.length; i++) {
            if(tokens[i].length()>1 || !operatorSet.contains(tokens[i].toCharArray()[0])) {
                stack.push(Integer.parseInt(tokens[i]));
            }else {
                if (stack.size()<2) {
                    throw new IllegalArgumentException("Illegal argument, two numbers has to be procceeded one operator");
                }
                int right = stack.pop();
                int left = stack.pop();
                int result;
                switch (tokens[i].toCharArray()[0]) {
                    case '*': result = left * right;
                        break;
                    case '+': result = left + right;
                        break;
                    case '-': result = left -right;
                        break;
                    case '/': result = left / right;
                        break;
                    default:
                        throw new IllegalArgumentException("Not supported operator");

                }
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static void main(String[]args) {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        String[]data = new String[] {"3", "-4", "+"};
        System.out.println(evaluateReversePolishNotation.evalRPN(data));

    }

}
