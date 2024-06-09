package Tree.BinaryTree;

public class SizeOfTree {

    static int size(BNode<Integer> node) {
        if (node == null)
            return 0;

        return 1 + size(node.left) + size(node.right);
    }

    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>();
        tree.makeRoot(4);
        tree.root.left = new BNode<>(10);
        tree.root.right = new BNode<>(12);
        tree.root.left.left = new BNode<>(22);
        tree.root.left.right = new BNode<>(24);
        tree.root.right.left = new BNode<>(10);
        tree.root.right.right = new BNode<>(20);

        System.out.println(size(tree.root));

    }
}
