package DLL.Excercises;

import DLL.DLL;
import DLL.DLLNode;
import java.util.Scanner;

//https://www.geeksforgeeks.org/find-pairs-given-sum-doubly-linked-list/

public class FindSumDLL {

    static void findPairToSum(DLL<Integer> list, int sumWanted) {
        DLLNode<Integer> first = list.getFirst();
        DLLNode<Integer> last = list.getLast();

        boolean sumFound = false;

        while (first != last) {
            int temp = first.element + last.element;

            if (temp == sumWanted) {
                System.out.printf("%d + %d = %d\n", first.element, last.element, sumWanted);
                last = last.pred;
                first = first.succ;
                sumFound = true;
            } else if (temp > sumWanted) {
                last = last.pred;
            } else {
                first = first.succ;
            }
        }

        if (!sumFound)
            System.out.println("There is no pair that give sum: " + sumWanted);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DLL<Integer> list = new DLL<Integer>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }

        System.out.println(list);
        findPairToSum(list, scanner.nextInt());

    }
}
