package Tree.ComplexTree;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SLLTree<E> implements Tree<E> {

    // SLLNode is the implementation of the Node interface
    class SLLNode<P> implements Node<P> {

        // Holds the links to the needed nodes
        SLLNode<P> parent, sibling, firstChild;

        // Hold the data
        P element;

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

    protected SLLNode<E> root;

    public SLLTree() {
        root = null;
    }

    public Node<E> root() {
        return root;
    }

    public Tree.Node<E> parent(Tree.Node<E> node) {
        return ((SLLNode<E>) node).parent;
    }

    public int childCount(Tree.Node<E> node) {
        SLLNode<E> temp = ((SLLNode<E>) node).firstChild;
        int count = 0;

        while (temp != null) {
            temp = temp.sibling;
            count++;
        }

        return count;
    }

    public void makeRoot(E elem) {
        root = new SLLNode<E>(elem);
    }

    public Node<E> addChild(Node<E> node, E elem) {
        SLLNode<E> child = new SLLNode<>(elem);
        SLLNode<E> parent = (SLLNode<E>) node;
        child.sibling = parent.firstChild;
        parent.firstChild = child;
        return child;
    }

    public void remove(Tree.Node<E> node) {
        SLLNode<E> child = ((SLLNode<E>) node);
        if (child.parent != null) { // check if it's the root
            if (child.parent.firstChild == child) {
                // remove the first and reference it's sibling to be first child
                child.parent.firstChild = child.sibling;
            } else {
                SLLNode<E> iterate = child.parent.firstChild;
                while (iterate.sibling != null) {

                    if (iterate.sibling == child)
                        iterate.sibling = child.sibling;

                    iterate = iterate.sibling;
                }
            }
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

    public Iterator<E> children(Tree.Node<E> node) {
        return new SLLTreeIterator<E>(((SLLNode<E>) node).firstChild);
    }

    public void printTree() {
        recursivePrintCall(root, "  ");
    }

    public void recursivePrintCall(SLLNode<E> node, String indent) {
        System.out.printf("%s%s\n", indent, node.element);

        SLLNode<E> iterate = node.firstChild;
        while (iterate != null) {
            recursivePrintCall(iterate, indent + "  ");
            iterate = iterate.sibling;
        }
    }

    public int findDegreeNode(SLLNode<E> node) {
        SLLNode<E> temp = node.firstChild;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.sibling;
        }

        return count;
    }

    public int maxDegreeTree() {
        return maxDegreeTreeRecursive(root);
    }

    public int maxDegreeTreeRecursive(SLLNode<E> node) {
        int maxDeg = childCount(node);
        SLLNode<E> temp = node.firstChild;

        while (temp != null) {
            maxDeg = Math.max(maxDeg, maxDegreeTreeRecursive(temp));
            temp = temp.sibling;
        }

        return maxDeg;
    }

    public static void main(String[] args) {
        SLLTree<String> tree = new SLLTree<>();
        tree.makeRoot("C:/");

        Tree.Node<String> windows = tree.addChild(tree.root, "Windows");
        tree.addChild(windows, "Media");

        Tree.Node<String> programFiles = tree.addChild(tree.root, "Program Files");

        Tree.Node<String> jetBrains = tree.addChild(programFiles, "JetBrains");
        tree.addChild(jetBrains, "Intellij");
        tree.addChild(jetBrains, "WebStorm");
        tree.addChild(jetBrains, "CLion");
        tree.addChild(jetBrains, "PyCharm");

        tree.addChild(programFiles, "MySQL");
        tree.addChild(programFiles, "Intel");

        Tree.Node<String> users = tree.addChild(tree.root, "Users");
        tree.addChild(users, "User1");
        Tree.Node<String> user2 = tree.addChild(users, "User2");
        tree.addChild(user2, "My Pictures");
        tree.addChild(user2, "My Documents");

        tree.addChild(users, "Public");

        tree.printTree();
        System.out.println("Degree of tree is: " + tree.maxDegreeTree());
    }

}