package Labs.lab5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

interface Stack<E> {

    // Elementi na stekot se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty ();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek ();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:

    public void clear ();
    // Go prazni stekot.

    public void push (E x);
    // Go dodava x na vrvot na stekot.

    public E pop ();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}

class ArrayStack<E> implements Stack<E> {
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack (int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }


    public boolean isEmpty () {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }


    public E peek () {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth-1];
    }


    public void clear () {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++)  elems[i] = null;
        depth = 0;
    }


    public void push (E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
    }


    public E pop () {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}

public class PostFixEvaluation {

    static int evaluatePostfix(char [] equation, int n) {
        Stack<Integer> stack = new ArrayStack<>(1000);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++)
            stringBuilder.append(equation[i]);

        String [] parts = stringBuilder.toString().split("\\s+");

        for (int i = 0; i < parts.length; i++) {
            String sign = parts[i];
            if (sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (sign){
                    case "+":
                        stack.push(num2 + num1);
                        break;
                    case "-" :
                        stack.push(num2 - num1);
                        break;
                    case "*" :
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                    default:
                }
            } else {
                stack.push(Integer.parseInt(parts[i]));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = evaluatePostfix(exp, exp.length);
        System.out.println(rez);

        br.close();

    }

}