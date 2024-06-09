package DLL.Excercises;

import DLL.DLL;
import DLL.DLLNode;
import java.util.Scanner;

// one ascending list and one descending list,
// merge them and make the new list descending

public class SortTwoDLLs {
    static DLL<Integer> sortList(DLL<Integer> descendingList, DLL<Integer> ascendingList) {
        DLL<Integer> result = new DLL<Integer>();

        DLLNode<Integer> descendingNode = descendingList.getFirst();
        DLLNode<Integer> ascendingNode = ascendingList.getLast();

        while (descendingNode != null && ascendingNode != null) {
            if (descendingNode.element > ascendingNode.element) {
                result.insertLast(descendingNode.element);
                descendingNode = descendingNode.succ;
            } else {
                result.insertLast(ascendingNode.element);
                ascendingNode = ascendingNode.pred;
            }
        }

        while (descendingNode != null) {
            result.insertLast(descendingNode.element);
            descendingNode = descendingNode.succ;
        }

        while (ascendingNode != null) {
            result.insertLast(ascendingNode.element);
            ascendingNode = ascendingNode.pred;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DLL<Integer> descendingList = new DLL<Integer>();
        DLL<Integer> ascendingList = new DLL<Integer>();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            ascendingList.insertLast(scanner.nextInt());
        }

        for (int i = 0; i < n; i++) {
            descendingList.insertLast(scanner.nextInt());
        }

        System.out.println(ascendingList);
        System.out.println(descendingList);

        System.out.println(sortList(descendingList, ascendingList));
    }
}
