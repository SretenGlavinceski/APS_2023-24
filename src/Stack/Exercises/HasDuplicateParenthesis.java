package Stack.Exercises;

import java.util.Scanner;
import java.util.Stack;

public class HasDuplicateParenthesis {

    static boolean hasDuplicateParenthesis(String equation) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == ')') {

                int counter = 1;
                while (stack.peek() != '(') {
                    counter++;
                    stack.pop();
                }

                stack.pop(); // remove the '('

                if (counter == 1)
                    return true;

            } else
                stack.push(equation.charAt(i));
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String equation = scanner.nextLine();
        System.out.println(hasDuplicateParenthesis(equation));
    }
}



