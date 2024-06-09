package DLL.Excercises;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import DLL.DLL;
import DLL.DLLNode;

//https://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/

public class IntersectionDLLs {

    static <E> DLL<E> intersection(DLL<E> list1, DLL<E> list2) {
        DLLNode<E> first1 = list1.getFirst();
        DLLNode<E> first2 = list2.getFirst();

        DLL<E> result = new DLL<E>();
        Set<E> set = new HashSet<>();

        while (first1 != null) {
            set.add(first1.element);
            first1 = first1.succ;
        }

        while (first2 != null) {
            if (set.contains(first2.element)) {
                result.insertLast(first2.element);
                set.add(first2.element);
            }
            first2 = first2.succ;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        DLL<Integer> listFirst = new DLL<Integer>();
        DLL<Integer> listSecond = new DLL<Integer>();

        for (int i = 0; i < n; i++)
            listFirst.insertLast(scanner.nextInt());

        for (int i = 0; i < m; i++)
            listSecond.insertLast(scanner.nextInt());

        DLL<Integer> resultList = intersection(listFirst, listSecond);
        System.out.println(listFirst);
        System.out.println(listSecond);
        System.out.println(resultList);
    }
}
