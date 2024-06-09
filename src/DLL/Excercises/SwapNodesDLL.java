package DLL.Excercises;

import java.util.Scanner;

import DLL.DLL;
import DLL.DLLNode;

//https://www.geeksforgeeks.org/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/
// but for DLL, not SLL

public class SwapNodesDLL {

    static void swapKNode(DLL<Integer> list, int node) {
        DLLNode<Integer> first = list.getFirst();
        DLLNode<Integer> last = list.getLast();

        if (node == 1) {
            int newFirst = list.deleteLast();
            int newLast = list.deleteFirst();
            list.insertFirst(newFirst);
            list.insertLast(newLast);
        } else {
            for (int i = 1; i < node; i++) {
                first = first.succ;
                last = last.pred;
            }

            DLLNode<Integer> before = first.pred;
            DLLNode<Integer> after = first.succ;

            first.succ = last.succ;
            first.pred = last.pred;

            if (last.pred != null)
                last.pred.succ = first;

            if (last.succ != null)
                last.succ.pred = first;

            last.pred = before;
            last.succ = after;

            if (before != null)
                before.succ = last;
            if (after != null)
                after.pred = last;
        }

        // check if every succ is correct
        System.out.println(list);

        // check if every pred is correct
        list.mirror();
        System.out.println(list);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DLL<Integer> list = new DLL<Integer>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }

        System.out.println(list);
        swapKNode(list, scanner.nextInt());

    }
}
