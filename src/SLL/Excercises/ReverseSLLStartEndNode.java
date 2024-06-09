package SLL.Excercises;

import SLL.SLL;
import SLL.SLLNode;

import java.util.Scanner;

//https://leetcode.com/problems/reverse-nodes-in-k-group/

public class ReverseSLLStartEndNode {

    static void reverseStartEndNodes(SLLNode<Integer> beforeStart, SLLNode<Integer> afterEnd) {
        SLLNode<Integer> start = beforeStart.succ;
        SLLNode<Integer> end = start;

        while (end != afterEnd) {
            end = end.succ;
        }

        SLLNode<Integer> next = null;

        while (start != afterEnd) {
            next = start.succ;
            start.succ = end;
            end = start;
            start = next;
        }

        beforeStart.succ = end;
    }



    public static void main(String[] args) {
        SLL<Integer> list = new SLL<Integer>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }

        System.out.println(list);
        reverseStartEndNodes(list.find(scanner.nextInt()), list.find(scanner.nextInt()));
        System.out.println(list);
    }
}
