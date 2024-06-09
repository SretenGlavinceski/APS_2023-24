package DLL.Excercises;

import java.util.Scanner;

import DLL.DLL;
import DLL.DLLNode;

//https://www.geeksforgeeks.org/rotate-doubly-linked-list-n-nodes/

public class RotateDLL { // rotate to left by n
    static <E> void rotateByN(DLL<E> list, int N) {
        DLLNode<E> current = list.getFirst();
        DLLNode<E> head = list.getFirst();
        N = N % list.getSize();

        int count = 1;
        while (count < N) {
            current = current.succ;
            count++;
        }

        DLLNode<E> endNode = current;

        while (current.succ != null)
            current = current.succ;

        current.succ = head;
        head.pred = current;

        list.setFirst(endNode.succ);
        list.setLast(endNode);
        list.getFirst().pred = null;
        endNode.succ = null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        DLL<String> list = new DLL<String>();

        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.next());
        }

        System.out.println("Original: " + list);
        rotateByN(list, scanner.nextInt());
        System.out.println("Rotated: " + list);
    }
}
