package Stack.Exercises;

import java.util.Scanner;
import java.util.Stack;

//https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
public class ReverseStackRecursive {

    static void insert_bottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty())
            stack.push(value);
        else {
            int curr = stack.pop();
            insert_bottom(stack, value);
            stack.push(curr);
        }
    }

    static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;

        int val = stack.pop();
        reverse(stack);
        insert_bottom(stack, val);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++)
            stack.push(scanner.nextInt());

        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }

}
