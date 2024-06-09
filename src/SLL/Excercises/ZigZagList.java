package SLL.Excercises;

import SLL.SLL;
import SLL.SLLNode;

import java.util.Scanner;

public class ZigZagList {

    static void makeZigZag(SLL<Integer> list) {
        SLLNode<Integer> first = list.getFirst();
        SLLNode<Integer> last = list.getFirst();
        boolean isPositive = first.element > 0;

        first = first.succ;

        while (first != null) {

            if (first.element == 0) {
                list.delete(first);
            } else if (isPositive && first.element > 0) {
                list.delete(first);
            } else if (!isPositive && first.element < 0) {
                list.insertBefore(Math.abs(last.element), first);
            }
            isPositive = first.element > 0;
            last = first;
            first = first.succ;
        }
    }

    public static void main(String[] args) {
        SLL<Integer> list = new SLL<Integer>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }

        System.out.println(list);
        makeZigZag(list);
        System.out.println(list);
    }

}
