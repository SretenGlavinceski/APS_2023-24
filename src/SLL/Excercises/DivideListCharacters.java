package SLL.Excercises;

//nanchyss — 08/30/2023 3:19 AM
//Дадена е двострано поврзана листа чии што јазли содржат по еден знак (буква).
// Листата треба да се подели на две резултантни листи, т.ш. во првата резултантна
// листа ќе бидат бидат сместени самогласките од влезната листа, а во втората – согласките.
// Јазлите во резултантните листи се додаваат наизменично почнувајќи од почетокот и
// крајот на влезната листа (т.е. прво се разгледува првиот елемент од листата и се додава
// во соодветната резултантна листа, па последниот, па вториот итн...)
//Во првиот ред од влезот се дадени буквите од кои се составени јазлите по редослед од влезната листа.
// Во првиот ред од излезот треба да се испечатат јазлите по редослед од првата резултантна листа
// (т.е. самогласките), во вториот ред од втората (т.е. согласките) .

//
//Input:
//a b c d e f g h i j
//Output:
//a i e
//j b c h d g f

import SLL.SLL;
import SLL.SLLNode;
import java.util.Scanner;

public class DivideListCharacters {

    static final String samoglaski = "aeiou";

    static void divideList(SLL<String> list) {

        SLLNode<String> first = list.getFirst();
        SLL<String> soglaskiList = new SLL<String>();
        SLL<String> samoglaskiList = new SLL<String>();

        while (first != null) {

            if (samoglaski.contains(first.element)) {
                samoglaskiList.insertLast(first.element);
            } else {
                soglaskiList.insertLast(first.element);
            }

            first = first.succ;
        }

        System.out.println("Samoglaski: " + samoglaskiList);
        System.out.println("Soglaski: " + soglaskiList);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SLL<String> list = new SLL<String>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.next());
        }

        System.out.println(list);
        divideList(list);
    }

}
