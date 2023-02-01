import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Conversor {

    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (!isOperator(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    private static boolean isOperator(char c) {
        ArrayList<Character> operators = new ArrayList<Character>(Arrays.asList('+', '-', '*', '/', '(', ')'));
        return operators.contains(c);
    }

    private static int getPrecedence(char c) {
        int priority;
        if (c == '+' || c == '-') {
            priority = 1;
        } else if (c == '*' || c == '/') {
            priority = 2;
        } else if (c == '^') {
            priority = 3;
        } else {
            priority = 0;
        }
        return priority;
    }

}
