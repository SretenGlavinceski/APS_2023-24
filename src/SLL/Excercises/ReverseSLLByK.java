package SLL.Excercises;

import SLL.SLL;
import SLL.SLLNode;

import java.util.Scanner;

public class ReverseSLLByK {

    static void reverseSubList(SLLNode<Integer> beforeLeft, int k) {

        SLLNode<Integer> left = beforeLeft.succ;
        SLLNode<Integer> right = left;
        SLLNode<Integer> temp = null;

        int j = k;
        while (j > 0) {
            if (right == null) {
                System.out.println("NULL");
                return;
            }
            j--;
            right = right.succ;
        }

        for (int i = 0; i < k; i++) {
            temp = left.succ;
            left.succ = right;
            right = left;
            left = temp;
        }

        beforeLeft.succ = right;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SLL<Integer> list = new SLL<Integer>();
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }

        System.out.println(list);

        SLLNode<Integer> dummyNode = new SLLNode<Integer>(0, list.getFirst());
        reverseSubList(dummyNode, 3);

        dummyNode = dummyNode.succ;
        while (dummyNode != null) {
            if (dummyNode.succ != null)
                System.out.print(dummyNode.element + " -> ");
            dummyNode = dummyNode.succ;
        }

    }
}
