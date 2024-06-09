package Labs.lab7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

interface Tree<E> {
    ////////////Accessors ////////////

    public Node<E> root();

    public Node<E> parent(Node<E> node);

    public int childCount(Node<E> node);

    ////////////Transformers ////////////
    public void makeRoot(E elem);

    public Node<E> addChild(Node<E> node, E elem);

    public void remove(Node<E> node);

    ////////////Iterator ////////////
    public Iterator<E> children(Node<E> node);

}

interface Node<E> {

    public E getElement();

    public void setElement(E elem);
}

class SLLTree<E> implements Tree<E> {

    public SLLNode<E> root;

    public SLLTree() {
        root = null;
    }

    public Node<E> root() {
        return root;
    }

    public Node<E> parent(Node<E> node) {
        return ((SLLNode<E>) node).parent;
    }

    public int childCount(Node<E> node) {
        SLLNode<E> tmp = ((SLLNode<E>) node).firstChild;
        int num = 0;
        while (tmp != null) {
            tmp = tmp.sibling;
            num++;
        }
        return num;
    }

    public void makeRoot(E elem) {
        root = new SLLNode<E>(elem);
    }

    public Node<E> addChild(Node<E> node, E elem) {
        SLLNode<E> tmp = new SLLNode<E>(elem);
        SLLNode<E> curr = (SLLNode<E>) node;
        tmp.sibling = curr.firstChild;
        curr.firstChild = tmp;
        tmp.parent = curr;
        return tmp;
    }

    public void remove(Node<E> node) {
        SLLNode<E> curr = (SLLNode<E>) node;
        if (curr.parent != null) {
            if (curr.parent.firstChild == curr) {
                // The node is the first child of its parent
                // Reconnect the parent to the next sibling
                curr.parent.firstChild = curr.sibling;
            } else {
                // The node is not the first child of its parent
                // Start from the first and search the node in the sibling list and remove it
                SLLNode<E> tmp = curr.parent.firstChild;
                while (tmp.sibling != curr) {
                    tmp = tmp.sibling;
                }
                tmp.sibling = curr.sibling;
            }
        } else {
            root = null;
        }
    }

    class SLLTreeIterator<T> implements Iterator<T> {

        SLLNode<T> start, current;

        public SLLTreeIterator(SLLNode<T> node) {
            start = node;
            current = node;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public T next() throws NoSuchElementException {
            if (current != null) {
                SLLNode<T> tmp = current;
                current = current.sibling;
                return tmp.getElement();
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (current != null) {
                current = current.sibling;
            }
        }
    }

    public Iterator<E> children(Node<E> node) {
        return new SLLTreeIterator<E>(((SLLNode<E>) node).firstChild);
    }

    void printTreeRecursive(Node<E> node, String indent) {
        if (node == null)
            return;

        System.out.println(indent + ((SLLNode<E>) node).element);
        SLLNode<E> temp = ((SLLNode<E>) node).firstChild;

        while (temp != null) {
            printTreeRecursive(temp, indent + " ");
            temp = temp.sibling;
        }
    }

    public void printTree() {
        printTreeRecursive(root, "");
    }

}

class SLLNode<P> implements Node<P> {

    // Holds the links to the needed nodes
    public SLLNode<P> parent, sibling, firstChild;
    // Hold the data
    public P element;

    public SLLNode(P o) {
        element = o;
        parent = sibling = firstChild = null;
    }

    public P getElement() {
        return element;
    }

    public void setElement(P o) {
        element = o;
    }
}

public class WindowsExplorer {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] commands = new String[N];

        for (int i = 0; i < N; i++)
            commands[i] = br.readLine();

        br.close();

        SLLTree<String> tree = new SLLTree<String>();
        tree.makeRoot("c:");
        SLLNode<String> current = tree.root;
        // vasiot kod stoi ovde

        for (String command : commands) {
            String[] parts = command.split("\\s+");

            switch (parts[0]) {
                case "CREATE" -> {
                    SLLNode<String> toAdd = new SLLNode<>(parts[1]);
                    SLLNode<String> temp = current.firstChild;

                    if (temp == null || current.firstChild.element.compareTo(toAdd.element) > 0) {
                        toAdd.sibling = current.firstChild;
                        current.firstChild = toAdd;

                    } else {
                        while (temp.sibling != null && temp.sibling.element.compareTo(toAdd.element) < 0)
                            temp = temp.sibling;

                        toAdd.sibling = temp.sibling;
                        temp.sibling = toAdd;

                    }

                    toAdd.parent = current;

                }
                case "OPEN" -> {
                    SLLNode<String> temp = current.firstChild;

                    while (temp != null) {
                        if (temp.element.equals(parts[1]))
                            current = temp;

                        temp = temp.sibling;
                    }
                }
                case "DELETE" -> {
                    SLLNode<String> temp = current.firstChild;

                    while (temp != null) {
                        if (temp.element.equals(parts[1]))
                            tree.remove(temp);

                        temp = temp.sibling;
                    }
                }
                case "BACK" -> {
                    if (current.parent != null)
                        current = current.parent;
                }
                case "PATH" -> {
                    Stack<String> stack = new Stack<>();

                    SLLNode<String> temp = current;

                    while (temp != null) {
                        stack.push(temp.element);
                        temp = temp.parent;
                    }

                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop() + "\\");
                    }
                    System.out.println();

                }
                case "PRINT" -> tree.printTree();
            }
        }


    }

}
