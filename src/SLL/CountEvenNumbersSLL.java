package SLL;

import SLL.SLL;

import java.util.Scanner;

public class CountEvenNumbersSLL {
    static int evenNumbersSLL(SLL<Integer> list) {
        int count = 0;
        SLLNode<Integer> temp = list.getFirst();
        while (temp != null) {
            if (temp.element %2 == 0)
                count++;
            temp = temp.succ;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SLL<Integer> list = new SLL<Integer>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }

        System.out.println("List is: " + list);

        System.out.println("Even numbers: " + evenNumbersSLL(list));
    }
}
