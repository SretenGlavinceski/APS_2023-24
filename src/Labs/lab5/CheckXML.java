package Labs.lab5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import Stack.Stack;
import Stack.ArrayStack;

public class CheckXML {

    static boolean isValidXML(String [] XMLTags) {
        Stack<String> stack = new ArrayStack<String>(100);

        for (String row : XMLTags) {
            if (row.startsWith("[/")) {
                String check = stack.pop();
//                System.out.println(check);
//                System.out.println(row.replaceAll("/", ""));
                if (!check.equals(row.replaceAll("/", "")))
                    return false;
            } else if (row.startsWith("[")) {
                stack.push(row);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String [] redovi = new String[n];

        for(int i=0;i<n;i++)
            redovi[i] = br.readLine();

        System.out.println(isValidXML(redovi) ? 1 : 0);

        br.close();
    }
}