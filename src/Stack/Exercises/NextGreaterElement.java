package Stack.Exercises;

import java.util.*;



// Problem is:
// https://www.geeksforgeeks.org/next-greater-element/

public class NextGreaterElement {

//    static void showNextMaxElement(int[] array) {
//        Stack<Integer> stack = new Stack<>();
//        Map<Integer, Integer> map = new LinkedHashMap<>(); // if you want to keep order as in the array
//
//        for (int j : array) map.put(j, -1);
//
//        stack.push(array[0]);
//
//        for (int i = 1; i < array.length; i++) {
//            int current = array[i];
//            if (current > stack.peek())
//                while (!stack.isEmpty())
//                    map.computeIfPresent(stack.pop(), (k, v) -> v + current + 1);
//
//            stack.push(current);
//
//        }
//
//        System.out.println(map);
//
//    }

    static void showNextMaxElement(int [] array) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = array.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && array[i] >= stack.peek())
                stack.pop();

            if (!stack.isEmpty())
                map.put(array[i], stack.peek());
            else
                map.put(array[i], -1);

            stack.push(array[i]);
        }

        for (int j : array)
            System.out.println(j + " -> " + map.get(j));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int [] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();

        showNextMaxElement(array);
    }

}
