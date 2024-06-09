package DLL;

import java.util.Scanner;

public class PalindromeDLL {

    static boolean isPalindrome(DLL<Integer> list) {
        DLLNode<Integer> first = list.getFirst();
        DLLNode<Integer> last = list.getLast();

        while (first != last) {
            if (!first.element.equals(last.element)) {
                return false;
            }
            first = first.succ;
            last = last.pred;
        }
        return true;
    }

    public static void main(String[] args) {
        DLL<Integer> list = new DLL<Integer>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }

        System.out.println(list);
        System.out.println("Palindrome: " + isPalindrome(list));

    }

}
