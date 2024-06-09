package Tree.BinaryTree;

public class SubtreeForGivenSum {

    static int sumSubTree(BNode<Integer> node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return node.info;

        return node.info + sumSubTree(node.left) + sumSubTree(node.right);
    }

    static boolean checkIfSubTreeExists(BNode<Integer> node, int sum) {
        if (node == null)
            return false;

        if (sumSubTree(node) == sum)
            return true;

        return checkIfSubTreeExists(node.left, sum)
                || checkIfSubTreeExists(node.right, sum);
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

        System.out.println(checkIfSubTreeExists(tree.root, 42));
    }
}
