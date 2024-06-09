package Stack.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//Write an algorithm that will calculate (evaluate) a mathematical expression
// that consists of numbers and operations for adding (*) and multiplying (*).

//Note: The operation of multiplying has precedence before the operation of adding.

public class ExpressionEvaluator {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

    private static int evaluateExpression(String string) {
        Stack<Integer> stack = new Stack<>();
        char operation = '+';

        for (int i = 0; i < string.length(); i++) {
            char current = string.charAt(i);

            if (!Character.isDigit(current)) {
                operation = string.charAt(i);
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(current);

            while (i + 1 < string.length() && Character.isDigit(string.charAt(i + 1))) {
                sb.append(string.charAt(i + 1));
                i++;
            }

            int num = Integer.parseInt(sb.toString());

            if (operation == '*') {
                int temp = stack.pop();
                stack.push(temp * num);

            } else stack.push(num);

        }

        return stack.stream().mapToInt(i -> i).sum();

    }

}

// Without Stack

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// public class ExpressionEvaluator {

//     public static int evaluateExpression(String expression){

//         String [] parts = expression.split("\\+");

//         int value = 0;

//         for (int i = 0; i < parts.length; i++) {
//             String [] nums = parts[i].split("\\*");
//             int temp = 1;
//             for (int j = 0; j < nums.length; j++) {
//                 temp *= Integer.parseInt(nums[j]);
//             }

//             value += temp;
//         }

//         return value;

//     }
//     public static void main(String[] args) throws IOException {
//         BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
//         System.out.println(evaluateExpression(input.readLine()));
//     }

// }
