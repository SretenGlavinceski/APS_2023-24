package Labs.lab5;

import java.util.NoSuchElementException;
import java.util.Scanner;

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}


interface Queue<E> {
    // Elementi na redicata se objekti od proizvolen tip.
    // Metodi za pristap:
    public boolean isEmpty();
    // Vrakja true ako i samo ako redicata e prazena.

    public int size();
    // Ja vrakja dolzinata na redicata.

    public E peek();
    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

    // Metodi za transformacija:

    public void clear();
    // Ja prazni redicata.

    public void enqueue(E x);
    // Go dodava x na kraj od redicata.

    public E dequeue();
    // Go otstranuva i vrakja pochetniot element na redicata.
}

class LinkedQueue<E> implements Queue<E> {

    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Elementite se zachuvuvaat vo jazli dod SLL
    // front i rear se linkovi do prviot i posledniot jazel soodvetno.
    SLLNode<E> front, rear;
    int length;

    // Konstruktor ...

    public LinkedQueue() {
        clear();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size() {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek() {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear() {
        // Ja prazni redicata.
        front = rear = null;
        length = 0;
    }

    public void enqueue(E x) {
        // Go dodava x na kraj od redicata.
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }

    public E dequeue() {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (front != null) {
            E frontmost = front.element;
            front = front.succ;
            if (front == null) rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}

class Person {
    String name;
    int id;
    int passport;
    int driversLicense;

    public Person(String name, int id, int passport, int driversLicense) {
        this.name = name;
        this.id = id;
        this.passport = passport;
        this.driversLicense = driversLicense;
    }

    public String getName() {
        return name;
    }

    public int Id() {
        return id;
    }

    public int Passport() {
        return passport;
    }

    public int DriversLicense() {
        return driversLicense;
    }
}

public class MVR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        Queue<Person> idQueue = new LinkedQueue<>();
        Queue<Person> passportQueue = new LinkedQueue<>();
        Queue<Person> driversQueue = new LinkedQueue<>();

        for (int i = 0; i < n; i++) {
            Person person = new Person(
                    scanner.nextLine(),
                    Integer.parseInt(scanner.nextLine()),
                    Integer.parseInt(scanner.nextLine()),
                    Integer.parseInt(scanner.nextLine()));

            if (person.Id() == 1)
                idQueue.enqueue(person);
            else if (person.Passport() == 1)
                passportQueue.enqueue(person);
            else driversQueue.enqueue(person);
        }

        while (!idQueue.isEmpty() || !passportQueue.isEmpty() || !driversQueue.isEmpty()) {

            if (!idQueue.isEmpty()) {
                Person person = idQueue.dequeue();
                if (person.Passport() == 1)
                    passportQueue.enqueue(person);
                else if (person.DriversLicense() == 1)
                    driversQueue.enqueue(person);
                else System.out.println(person.getName());
                continue;
            }

            if (!passportQueue.isEmpty()) {
                Person person = passportQueue.dequeue();
                if (person.DriversLicense() == 1)
                    driversQueue.enqueue(person);
                else System.out.println(person.getName());
                continue;
            }

            if (!driversQueue.isEmpty()) {
                Person person = driversQueue.dequeue();
                System.out.println(person.getName());
            }
        }
    }
}
