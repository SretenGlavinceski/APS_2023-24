package SLL.Excercises;
import java.util.Scanner;

public class ExamTerm2 {
    public static void deleteEven(SLL<Integer> list1) {
        SLLNode<Integer> node = list1.getFirst();

        while (node != null) {
            int count = 0;
            SLLNode<Integer> temp = list1.getFirst();
            while (temp != null) {
                if (temp.element.equals(node.element))
                    count++;
                temp = temp.succ;
            }

            if (count % 2 == 0) {
                list1.delete(node);
                temp = node.succ;
                while (temp != null) {
                    if (temp.element.equals(node.element)) {
                        list1.delete(temp);
                    }
                    temp = temp.succ;
                }
            }

            node = node.succ;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL<Integer> list1 = new SLL<Integer>();

        //todo: enter code here

        for (int i = 0; i < n; i++) {
            list1.insertLast(scanner.nextInt());
        }

        deleteEven(list1);
        //todo: enter code here

        System.out.println(list1);
    }
}