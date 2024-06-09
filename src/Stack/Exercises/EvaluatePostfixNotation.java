package Stack.Exercises;

import java.util.Scanner;
import java.util.Stack;

// zadaca od auditoriski

public class EvaluatePostfixNotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String equation = scanner.nextLine();
        System.out.println("Result: " + evaluate(equation));
    }

    private interface Calculator {
        int operation(int num1, int num2, char op);
    }

    private static int evaluate(String equation) {
        Stack<Integer> stack = new Stack<>();
        Calculator calculator = (num1, num2, op) -> {
            if (op == '+')
                return num1 + num2;
            if (op == '-')
                return num1 - num2;
            if (op == '*')
                return num1 * num2;
            if (op == '/')
                return num1 / num2;
            return -1;
        };

        for (int i = 0; i < equation.length(); i++) {
            char current = equation.charAt(i);
            if (current == ' ')
                continue;

            if (Character.isDigit(current)) {
                StringBuilder sb = new StringBuilder();

                while (i < equation.length() && Character.isDigit(current)) {
                    sb.append(current);
                    current = equation.charAt(i + 1);
                    i++;
                }
                stack.push(Integer.parseInt(sb.toString()));
            }

            else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(calculator.operation(Math.max(num1, num2), Math.min(num1, num2), current));

            }
        }

        return stack.pop();
    }
}
