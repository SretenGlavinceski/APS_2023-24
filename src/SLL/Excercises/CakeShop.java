package SLL.Excercises;

import java.util.Scanner;

class SLLNodeCake {
    String name;
    int price;
    SLLNodeCake succ;

    public SLLNodeCake(String name, int price, SLLNodeCake succ) {
        this.name = name;
        this.price = price;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return name;
    }
}

class SLLCake {
    SLLNodeCake first;

    public SLLCake() {
        this.first = null;
    }

    public void insertFirst(String name, int price) {
        SLLNodeCake ins = new SLLNodeCake(name, price, first);
        first = ins;
    }

    public void insertLast(String name, int price) {
        if (first != null) {
            SLLNodeCake tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNodeCake ins = new SLLNodeCake(name, price, null);
            tmp.succ = ins;
        } else {
            insertFirst(name, price);
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (first != null) {
            SLLNodeCake tmp = first;
            ret.append(tmp).append("\n");
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret.append(tmp).append("\n");
            }
        } else
            ret = new StringBuilder("NO ELEMENTS");
        return ret.toString();
    }
}

public class CakeShop {

    public static void removeCakes(SLLCake cakes) {
        double avr = 0.0;
        double size = 0.0;
        SLLNodeCake first = cakes.first;

        while (first != null) {
            avr += first.price;
            size++;
            first = first.succ;
        }
        avr /= size;

        SLLNodeCake curr = cakes.first.succ;
        SLLNodeCake before = cakes.first;

        if (before.price > avr) {
            cakes.first = cakes.first.succ;
            before = cakes.first;
        }

        while (curr!=null) {
            if (curr.price > avr)
                before.succ = curr.succ;
            else
                before = curr;
            curr = curr.succ;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLLCake cakes = new SLLCake();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            cakes.insertLast(parts[0], Integer.parseInt(parts[1]));
        }

        removeCakes(cakes);
        System.out.println(cakes.toString());
    }
}

// input
//8
//Milka 4600
//Jagoda 500
//Cresha 800
//Meshana 300
//ChokoladoKaramela 5500
//Malina 200
//Vanilla 4000
//Vishna 7500

// output
//Jagoda
//Cresha
//Meshana
//Malina