package DLL;

public class DLL<E> {
    private DLLNode<E> first, last;

    public DLL() {
        // Construct an empty SLL
        this.first = null;
        this.last = null;
    }

    public void insertFirst(E o) {
        DLLNode<E> node = new DLLNode<E>(o, null, first);
        if (first == null)
            last = node;
        else
            first.pred = node;

        first = node;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> node = new DLLNode<E>(o, last, null);
            last.succ = node;
            last = node;
        }
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if (after == last) {
            insertLast(o);
            return;
        }
        DLLNode<E> node = new DLLNode<E>(o, after, after.succ);
        after.succ.pred = node;
        after.succ = node;
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if (first == before){
            insertFirst(o);
            return;
        }
        DLLNode<E> node = new DLLNode<E>(o, before.pred, before);
        before.pred.succ = node;
        before.pred = node;
    }
    public E deleteFirst() {
        if (first == null)
            return null;
        DLLNode<E> temp = first;
        first = first.succ;
        if (first != null)
            first.pred = null;
        else
            last = null;

        return temp.element;
    }

    public E deleteLast() {
        if (first == null)
            return null;
        if (first.succ == null)
            deleteFirst();

        DLLNode<E> temp = last;
        last = last.pred;
        last.succ = null;
        return temp.element;
    }

    public E delete(DLLNode<E> node) {
        if (node == first) {
            return deleteFirst();
        }
        if (node == last) {
            return deleteLast();
        }

        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;

    }

    public DLLNode<E> find(E o) {
        if (first != null) {
            DLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int getSize() {
        int listSize = 0;
        DLLNode<E> tmp = first;
        while(tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        if (first == null)
            return "Prazna lista!!!";

        StringBuilder sb = new StringBuilder();
        DLLNode<E> temp = first;

        while (temp.succ != null) {
            sb.append(temp.element).append("<->");
            temp = temp.succ;
        }

        sb.append(temp.element);
        return sb.toString();
    }

    public String toStringR() {
        String ret = new String();
        if (last != null) {
            DLLNode<E> tmp = last;
            ret += tmp.toString();
            while (tmp.pred != null) {
                tmp = tmp.pred;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {

        return last;
    }

    public void setFirst(DLLNode<E> newFirst) {
        this.first = newFirst;
    }

    public void setLast(DLLNode<E> newLast) {
        this.last = newLast;
    }

    public void mirror() {
        DLLNode<E> temp = null;
        DLLNode<E> current = first;
        last = first;
        while (current != null) {
            temp = current.pred;
            current.pred = current.succ;
            current.succ = temp;
            current = current.pred;
        }

        if (temp != null && temp.pred != null) {
            first = temp.pred;
        }

    }
}

