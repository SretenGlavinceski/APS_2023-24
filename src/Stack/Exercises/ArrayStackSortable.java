    package Stack.Exercises;
    
    import java.util.Scanner;
    import java.util.Stack;
    
    public class ArrayStackSortable {
    
        static boolean isStackable(Stack<Integer> stack, int n) {
            int prev = stack.pop();
    
            for (int i = 1; i < n; i++){
                int curr = stack.pop();
                if (prev > curr)
                    return false;
                prev = curr;
            }
    
            return true;
        }
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            int n = scanner.nextInt();
            Stack<Integer> stack = new Stack<>();
    
            for (int i = 0; i < n; i++)
                stack.push(scanner.nextInt());
    
            System.out.println(isStackable(stack, n));
        }
    }
