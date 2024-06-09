//package Labs.lab3;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Stack;
//
//
//public class ArithmeticExpression {
//
//    private interface Calculator {
//        int calculate(int num1, int num2, char op);
//    }
//
//    static Calculator calculator = (num1, num2, op) -> {
//        if (op == '+')
//            return num1 + num2;
//        if (op == '-')
//            return num1 - num2;
//        if (op == '*')
//            return num1 * num2;
//        if (op == '/')
//            return num1 / num2;
//        return -1;
//    };
//
//    static int calculateExpression(char[] exp, int index, int n) {
//
//        Stack<Character> stack = new Stack<>();
//        int result = 0;
//
//        for (int i = 0; i < exp.length; i++) {
//            if (exp[i] == '(') {
//                stack.push(exp[i]);
//            }
//        }
//
//    }
//
//
//    public static void main(String[] args) throws Exception {
//        int i,j,k;
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String expression = br.readLine();
//        char exp[] = expression.toCharArray();
//
//        int rez = calculateExpression(exp, 0, exp.length-1);
//        System.out.println(rez);
//
//        br.close();
//
//    }
//
//}
