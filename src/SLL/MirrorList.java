package SLL;

import SLL.SLL;

import java.util.Scanner;

public class MirrorList {

    static <E> SLL<E> reverseList(SLL<E> list) {
        SLL<E> temp = list;
        temp.mirror();
        return temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SLL<String> list = new SLL<String>();
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.next());
        }

        System.out.println("List: " + list);

        System.out.println("Reversed list: " + reverseList(list));
    }
}
