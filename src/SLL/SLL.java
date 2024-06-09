package SLL;

public class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int size() {
        int listSize = 0;
        SLLNode<E> node = first;
        while (node != null) {
            listSize++;
            node = node.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        if (first == null) {
            return "Listata e prazna";
        }

        StringBuilder sb = new StringBuilder();
        SLLNode<E> node = first;

        while (node.succ != null) {
            sb.append(node.element).append(" -> ");
            node = node.succ;
        }
        sb.append(node.element);

        return sb.toString();
    }

    public void insertFirst(E o) {
        SLLNode<E> node = new SLLNode<E>(o, first);
        first = node;
    }

    public void insertAfter(E o, SLLNode<E> node) {

        if (node != null) {
            SLLNode<E> temp = new SLLNode<E>(o, node.succ);
            node.succ = temp;
        } else {
            System.out.println("Dadenot jazol e null");
        }

    }

    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> temp = first;
            if (first == before) {
                insertFirst(o);
                return;
            }
            while (temp.succ != before && temp.succ != null) {
                temp = temp.succ;
            }
            if (temp.succ == before) {
                SLLNode<E> node = new SLLNode<E>(o, temp.succ);
                temp.succ = node;
            }
        } else {
            System.out.println("Listata e prazna");
        }

    }

    public void insertLast(E o) {
        if (first == null) {
            insertFirst(o);
            return;
        }

        SLLNode<E> node = first;
        while (node.succ != null) {
            node = node.succ;
        }

        node.succ = new SLLNode<E>(o, null);
    }

    public E deleteFirst() {
        if (first == null) {
            System.out.println("Listata e prazna");
            return null;
        }

        SLLNode<E> temp = first;
        first = first.succ;
        return temp.element;
    }

    public E delete(SLLNode<E> node) {
        if (first == null) {
            System.out.println("Listata e prazna");
            return null;
        }
        SLLNode<E> temp = first;

        while (temp.succ != node && temp.succ != null) {
            temp = temp.succ;
        }

        if (temp.succ == node) {
            temp.succ = temp.succ.succ;
            return node.element;
        } else {
            System.out.println("Elementot ne postoi vo listata");
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first == null) {
            System.out.println("Listata e prazna");
            return null;
        }
        SLLNode<E> temp = first;
        while (temp != null) {
            if (temp.element.equals(o))
                return temp;
            temp = temp.succ;
        }

        System.out.println("Elementot ne postoi vo listata");
        return null;
    }

    public void merge(SLL<E> in) {
        if (first == null) {
            first = in.getFirst();
            return;
        }

        SLLNode<E> last = first;
        while (last.succ != null)
            last = last.succ;
        last.succ = in.getFirst();
    }

    public void mirror() {
        if (first == null)
            return;

        SLLNode<E> temp = first;
        SLLNode<E> next;
        SLLNode<E> before = null;

        while (temp != null) {
            next = temp.succ;
            temp.succ = before;
            before = temp;
            temp = next;
        }

        first = before;

    }
}

