import java.util.Stack;

public class Calculator {
    public static float evaluate(String expression) {
        Stack<Float> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push((float) Character.getNumericValue(c));
            } else {
                Float a = stack.pop();
                Float b = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(b + a);
                        break;
                    case '-':
                        stack.push(b - a);
                        break;
                    case '*':
                        stack.push(b * a);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                    case '^':
                        stack.push((float) Math.pow(b, a));
                        break;
                }
            }
        }
        return stack.pop();
    }

}
