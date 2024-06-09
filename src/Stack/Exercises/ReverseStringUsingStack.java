package Stack.Exercises;

import Stack.Stack;
import Stack.ArrayStack;
import java.util.Scanner;

public class ReverseStringUsingStack {

    static String reverse(String s) {
        Stack<Character> stack = new ArrayStack<Character>(s.length());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++)
            stack.push(s.charAt(i));

        for (int i = 0; i < s.length(); i++)
            sb.append(stack.pop());

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.next();
        System.out.println("Reversed: " + reverse(string));
    }
}
