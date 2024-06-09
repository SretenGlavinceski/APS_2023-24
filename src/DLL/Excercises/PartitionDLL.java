package DLL.Excercises;

import java.util.Scanner;

import DLL.DLL;
import DLL.DLLNode;

//https://www.geeksforgeeks.org/partitioning-a-linked-list-around-a-given-value-and-keeping-the-original-order/

//Input : 1->4->3->2->5->2->3,
//        x = 3
//Output: 1->2->2->3->3->4->5
//
//Input : 1->4->2->10
//        x = 3
//Output: 1->2->4->10
//
//Input : 10->4->20->10->3
//        x = 3
//Output: 3->10->4->20->10

public class PartitionDLL {

    static void partitionList(DLL<Integer> list, int value) {
        DLLNode<Integer> current = list.getFirst();

        if (current.succ == null)
            return;

        DLLNode<Integer> smallerThanHead = null;
        DLLNode<Integer> smallerThanLast = null;
        DLLNode<Integer> equalToHead = null;
        DLLNode<Integer> equalToLast = null;
        DLLNode<Integer> greaterThanHead = null;
        DLLNode<Integer> greaterThanLast = null;

        while (current != null) {

            if (current.element < value) {
                if (smallerThanHead == null) {
                    smallerThanHead = current;
                } else {
                    smallerThanLast.succ = current;
                    current.pred = smallerThanLast;
                }
                smallerThanLast = current;
            }

            if (current.element == value) {
                if (equalToHead == null) {
                    equalToHead = current;
                } else {
                    equalToLast.succ = current;
                    current.pred = equalToLast;
                }
                equalToLast = current;
            }

            if (current.element > value) {
                if (greaterThanHead == null) {
                    greaterThanHead = current;
                } else {
                    greaterThanLast.succ = current;
                    current.pred = greaterThanLast;
                }
                greaterThanLast = current;
            }

            current = current.succ;
        }


        DLLNode<Integer> resultHead = (smallerThanHead != null) ?
                smallerThanHead : equalToHead != null ? equalToHead : greaterThanHead;

        DLLNode<Integer> resultLast = (smallerThanLast != null) ?
                smallerThanLast : equalToLast != null ? equalToLast : greaterThanLast;

        if (smallerThanHead != null) {
            resultLast.succ = equalToHead != null ? equalToHead : greaterThanHead;
            if (equalToHead != null) {
                equalToHead.pred = resultLast;
                resultLast = equalToLast;
            } else {
                greaterThanHead.pred = resultLast;
                resultLast = greaterThanLast;
            }
        }

        if (equalToHead != null) {
            resultLast.succ = greaterThanHead;
            if (greaterThanHead!=null) {
                greaterThanHead.pred = resultLast;
                resultLast = greaterThanLast;
                resultLast.succ = null;
            }
        }

        list.setFirst(resultHead);
        list.setLast(resultLast);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DLL<Integer> list = new DLL<Integer>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }

        System.out.println(list);
        partitionList(list, scanner.nextInt());
        System.out.println(list);
    }
}
