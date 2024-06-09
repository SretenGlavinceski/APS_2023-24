package Tree.BinaryTree;

public class BTree<E> {

    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<E>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode<E>(elem);
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {
        BNode<E> newNode = new BNode<>(elem);

        if (where == BNode.LEFT) {
            if (node.left != null)
                return null;
            node.left = newNode;
        } else {
            if (node.right != null)
                return null;
            node.right = newNode;
        }

        return newNode;
    }

    public void inorder() {
        inorderR(root);
        System.out.println();
    }

    public void inorderR(BNode<E> node) {
        if (node == null)
            return;

        inorderR(node.left);
        System.out.print(node.info + " ");
        inorderR(node.right);
    }

    public void preorder() {
        preorderR(root);
        System.out.println();
    }

    public void preorderR(BNode<E> node) {
        if (node == null)
            return;

        System.out.print(node.info + " ");
        preorderR(node.left);
        preorderR(node.right);
    }

    public void postorder() {
        postorderR(root);
        System.out.println();
    }

    public void postorderR(BNode<E> node) {
        if (node == null)
            return;

        postorderR(node.left);
        postorderR(node.right);
        System.out.print(node.info + " ");
    }

    public void inorderNonRecursive() {
        Stack<BNode<E>> stack = new ArrayStack<>(100);

        BNode<E> temp = root;

        while (true) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }

            if (stack.isEmpty())
                break;

            temp = stack.pop();
            System.out.print(temp.info + " ");

            temp = temp.right;
        }
    }

    public void preorderNonRecursive() {
        Stack<BNode<E>> stack = new ArrayStack<>(100);

        BNode<E> temp = root;
        while (true) {
            while (temp != null) {
                System.out.print(temp.info + " ");
                stack.push(temp);
                temp = temp.left;
            }

            if (stack.isEmpty())
                break;

            temp = stack.pop();
            temp = temp.right;
        }
    }

    public void postorderNonRecursive() {
        Stack<BNode<E>> stackToPrint = new ArrayStack<>(100);
        Stack<BNode<E>> stackTemp = new ArrayStack<>(100);

        stackTemp.push(root);
        while (!stackTemp.isEmpty()) {
            BNode<E> temp = stackTemp.pop();
            stackToPrint.push(temp);

            if (temp.left != null) {
                stackTemp.push(temp.left);
            }
            if (temp.right != null) {
                stackTemp.push(temp.right);
            }
        }

        while (!stackToPrint.isEmpty()) {
            System.out.print(stackToPrint.pop().info + " ");
        }
    }

    int insideNodesR(BNode<E> node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 0;

        return insideNodesR(node.left) + insideNodesR(node.right) + 1;
    }

    public int insideNodes() {
        return insideNodesR(root);
    }

    int leavesR(BNode<E> node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 1;

        return leavesR(node.left) + leavesR(node.right);
    }

    public int leaves() {
        return leavesR(root);
    }

    int depthR(BNode<E> node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 0;

        return 1 + Math.max(depthR(node.left), depthR(node.right));
    }

    public int depth() {
        return depthR(root);
    }

    void mirrorR(BNode<E> node) {
        if (node == null)
            return;

        mirrorR(node.left);
        mirrorR(node.right);

        BNode<E> temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public void mirror() {
        mirrorR(root);
    }

    public static void main(String[] args) {
        BNode<Character> a, b, c;
        BTree<Character> tree = new BTree<Character>('F');
        a = tree.addChild(tree.root, BNode.LEFT, 'D');
        b = tree.addChild(a, BNode.LEFT, 'B');
        c = tree.addChild(b, BNode.LEFT, 'A');
        c = tree.addChild(b, BNode.RIGHT, 'C');
        c = tree.addChild(a, BNode.RIGHT, 'E');
        a = tree.addChild(tree.root, BNode.RIGHT, 'G');
        b = tree.addChild(a, BNode.RIGHT, 'I');
        c = tree.addChild(b, BNode.LEFT, 'H');
        c = tree.addChild(b, BNode.RIGHT, 'J');

        tree.inorder();
//        tree.inorderNonRecursive();
//        tree.preorder();
//        tree.preorderNonRecursive();
//        tree.postorder();
//        tree.postorderNonRecursive();
//
//        System.out.println("Brojot na vnatresni jazli e " + tree.insideNodes());
//        System.out.println("Brojot na listovi e " + tree.leaves());
//        System.out.println("Dlabocinata na drvoto e " + tree.depth());
//
        tree.mirror();
        tree.inorder();
    }

}
