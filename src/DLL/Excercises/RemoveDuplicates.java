package DLL.Excercises;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import DLL.DLL;
import DLL.DLLNode;

//https://www.geeksforgeeks.org/remove-duplicates-unsorted-doubly-linked-list/

public class RemoveDuplicates {

    static void removeDuplicatesList(DLL<Integer> list) {// using hashset
        Set<Integer> distinct = new HashSet<>();
        DLLNode<Integer> first = list.getFirst();

        while (first != null) {
            if (distinct.contains(first.element)) {
                list.delete(first);
            } else {
                distinct.add(first.element);
            }
            first = first.succ;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        DLL<Integer> list = new DLL<Integer>();

        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }

        System.out.println("Original: " + list);
        removeDuplicatesList(list);
        System.out.println("Removed duplicates: " + list);

    }

}
