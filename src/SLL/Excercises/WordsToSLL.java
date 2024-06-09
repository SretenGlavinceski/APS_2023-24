package SLL.Excercises;

// cat,dog,cow --> c->a->t->,->d->o->g->,->c->o->w

import SLL.SLL;
import SLL.SLLNode;

import java.util.Scanner;

public class WordsToSLL {

    static void putWordsTogether(SLL<String> list) {
        // every node is a char, part of a bigger word
        SLL<String> result = new SLL<String>();
        StringBuilder sb = new StringBuilder();
        SLLNode<String> first = list.getFirst();

        while (first != null) {

            if (first.element.equals(",")) {
                result.insertLast(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(first.element);
            }

            first = first.succ;
        }

        result.insertLast(sb.toString());

        System.out.println(result);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SLL<String> list = new SLL<String>();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.next());
        }

        System.out.println(list);
        putWordsTogether(list);

    }
}
