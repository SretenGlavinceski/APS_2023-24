package SLL.Excercises;

//Dadena lista i posle nea element, da se vnese toj element vo listata po prviot element,
// pa po narednite 2, pa po narednite 3 itn.
//Primer lista 1 2 3 4 5 6 7 8
//Element 9
//Rezultat 1 9 2 3 9 4 5 6 9 7 8

import java.util.Scanner;
import SLL.SLL;
import SLL.SLLNode;

public class InsertingElementSLL {

    static void addElementToList(SLL<Integer> list, int element) {
        SLLNode<Integer> first = list.getFirst();

        int counter = 0;
        int flag = 1;
        while (first != null) {

            if (flag == 0) {
                list.insertBefore(element, first);
                flag = ++counter;
            } else {
                flag--;
            }

            first = first.succ;
        }

        System.out.println(list);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SLL<Integer> list = new SLL<Integer>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }

        System.out.println(list);

        addElementToList(list, 9);
    }
}
