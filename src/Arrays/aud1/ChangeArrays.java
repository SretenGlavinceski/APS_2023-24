package Arrays.aud1;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
class Array<E> {
    private E[] data; // declared to be an Object since it would be too
    // complicated with generics
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public void insertLast(E o) {
        //check if there is enough capacity, and if not - resize
        if(size + 1 > data.length)
            this.resize();
        data[size++] = o;
    }

    public void insert(int position, E o) {
        // before all we check if position is within range
        if (position >= 0 && position <= size) {
            //check if there is enough capacity, and if not - resize
            if(size + 1 > data.length)
                this.resize();
            //copy the data, before doing the insertion
            for(int i=size;i>position;i--) {
                data[i] = data[i-1];
            }
            data[position] = o;
            size++;
        } else {
            System.out.println("Ne mozhe da se vmetne element na taa pozicija");
        }
    }

    public void set(int position, E o) {
        if (position >= 0 && position < size)
            data[position] = o;
        else
            System.out.println("Ne moze da se vmetne element na dadenata pozicija");
    }

    public E get(int position) {
        if (position >= 0 && position < size)
            return data[position];
        else
            System.out.println("Ne e validna dadenata pozicija");
        return null;
    }

    public int find(E o) {
        for (int i = 0; i < size; i++) {
            if(o.equals(data[i]))
                return i;
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    public void delete(int position) {
        // before all we check if position is within range
        if (position >= 0 && position < size) {
            // first resize the storage array
            E[] newData = (E[]) new Object[size - 1];
            // copy the data prior to the delition
            for (int i = 0; i < position; i++)
                newData[i] = data[i];
            // move the data after the deletion
            for (int i = position + 1; i < size; i++)
                newData[i - 1] = data[i];
            // replace the storage with the new array
            data = newData;
            size--;
        }
    }

    public void resize() {
        // first resize the storage array
        E[] newData = (E[]) new Object[size*2];
        // copy the data
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        // replace the storage with the new array
        this.data = newData;
    }

    @Override
    public String toString() {
        String ret = new String();
        if(size>0) {
            ret = "{";
            ret += data[0];
            for(int i=1;i<size;i++) {
                ret += "," + data[i];
            }
            ret+="}";
            return ret;
        }
        else {
            ret = "Prazna niza!";
        }
        return ret;
    }

}

public class ChangeArrays <E> {

    public void compareAndChangeArrays(Array<E> array1, Array<E> array2) {
        if (array1.getSize() != array2.getSize()) {
            System.out.println("Not same sized arrays!");
            return;
        }

        for (int i = 0; i < array1.getSize(); i++) {
            if (array1.get(i).equals(array2.get(i))) {
                array1.delete(i);
                array2.delete(i);
                i--;
            }
        }
    }



    public static void main(String[] args) {
        Array<String> niza1 = new Array<String>(4);
        niza1.insertLast("nb11");
        niza1.insertLast("b1");
        niza1.insertLast("b2");
        niza1.insertLast("nb12");

        Array<String> niza2 = new Array<String>(4);
        niza2.insertLast("nb21");
        niza2.insertLast("b1");
        niza2.insertLast("b2");
        niza2.insertLast("nb22");

        System.out.println("Nizite pred primenuvanjeto na funkcijata: ");
        System.out.println(niza1.toString());
        System.out.println(niza2.toString());

        ChangeArrays<String> pom = new ChangeArrays<String>();
        pom.compareAndChangeArrays(niza1, niza2);

        System.out.println("Nizite po primenuvanjeto na funkcijata: ");
        System.out.println(niza1.toString());
        System.out.println(niza2.toString());

        Array<Integer> niza3 = new Array<Integer>(3);
        niza3.insertLast(10);
        niza3.insertLast(13);
        niza3.insertLast(7);

        Array <Integer> niza4 = new Array<Integer>(3);
        niza4.insertLast(5);
        niza4.insertLast(13);
        niza4.insertLast(3);

        System.out.println("Nizite pred primenuvanjeto na funkcijata: ");
        System.out.println(niza3.toString());
        System.out.println(niza4.toString());

        ChangeArrays<Integer> pom2 = new ChangeArrays<Integer>();
        pom2.compareAndChangeArrays(niza3, niza4);

        System.out.println("Nizite po primenuvanjeto na funkcijata: ");
        System.out.println(niza3.toString());
        System.out.println(niza4.toString());
    }

}
