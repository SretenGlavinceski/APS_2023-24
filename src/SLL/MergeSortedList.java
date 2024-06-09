package SLL;

import SLL.SLL;

import java.util.Scanner;

public class MergeSortedList {

    static <E extends Comparable<E>> SLL<E> mergeLists(SLL<E> list1, SLL<E> list2) {
        SLL<E> result = new SLL<E>();
        SLLNode<E> currFirstList = list1.getFirst();
        SLLNode<E> currSecondList = list2.getFirst();

        while (currFirstList != null && currSecondList != null) {
            if (currFirstList.element.compareTo(currSecondList.element) < 0) {
                result.insertLast(currFirstList.element);
                currFirstList = currFirstList.succ;
            } else {
                result.insertLast(currSecondList.element);
                currSecondList = currSecondList.succ;
            }
        }

        if (currFirstList != null) {
            while (currFirstList != null) {
                result.insertLast(currFirstList.element);
                currFirstList = currFirstList.succ;
            }
        }

        if (currSecondList != null) {
            while (currSecondList != null) {
                result.insertLast(currSecondList.element);
                currSecondList = currSecondList.succ;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SLL<String> list1 = new SLL<String>();
        System.out.println("First list:");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list1.insertLast(scanner.next());
        }

        SLL<String> list2 = new SLL<String>();
        System.out.println("Second list:");
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            list2.insertLast(scanner.next());
        }

        System.out.println(list1);
        System.out.println(list2);
        System.out.println("Merge Sorted list: " + mergeLists(list1, list2));

    }

}
