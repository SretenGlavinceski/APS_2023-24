package SLL.Excercises;

import java.util.Scanner;

import SLL.SLLNode;
import SLL.SLL;

public class DeleteSLL {

    public static void change(SLL<Integer> list, int br) {
        SLLNode<Integer> node = list.getFirst();
        SLLNode<Integer> firstInstance = null;
        int counter = 0;

        while (node != null) {
            if (node.element == br) {
                if (firstInstance == null) {
                    firstInstance = node;
                }
                counter++;
            }
            node = node.succ;
        }

        if (firstInstance != null && counter % 2 != 0) {
            list.insertBefore(br, firstInstance);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int n, broj;
        SLL<Integer> list1 = new SLL<Integer>();
        n = scan.nextInt();
        for(int i = 0; i<n; i++) {
            list1.insertLast(scan.nextInt());
        }
        int br = scan.nextInt();
        change(list1,br);
        System.out.println(list1);


    }
}
