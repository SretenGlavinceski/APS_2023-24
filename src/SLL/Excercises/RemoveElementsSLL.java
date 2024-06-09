package SLL.Excercises;

import SLL.SLL;
import SLL.SLLNode;
import java.util.Scanner;
// case1
// input
// 8
// 1 2 3 4 5 6 7 8
// 2 2
// output
// 1 -> 2 -> 5 -> 6

// case2
// input 10
// 10
// 1 2 3 4 5 6 7 8 9 10
// 3 2
// output
// 1 -> 2 -> 3 -> 6 -> 7 -> 8

// case3
// input
// 8
// 5 10 15 20 25 30 35 40
// 4 3
// output
//5 -> 10 -> 15 -> 20 -> 40

public class RemoveElementsSLL {

    static void eraseElements(SLL<Integer> list, int m, int n) {
        SLLNode<Integer> first = list.getFirst();
        int temp = m;
        boolean toRemove = false;

        while (first != null) {
            if (!toRemove) {
                while (temp > 0 && first != null) {
                    temp--;
                    first = first.succ;
                }
                temp = n;
                toRemove = true;
            } else {
                while (temp > 0 && first != null) {
                    temp--;
                    list.delete(first);
                    first = first.succ;
                }
                temp = m;
                toRemove = false;
            }
        }

        System.out.println(list);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        SLL<Integer> list = new SLL<Integer>();

        for (int i = 0; i < N; i++)
            list.insertLast(scanner.nextInt());

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        eraseElements(list, m, n);
    }

}
