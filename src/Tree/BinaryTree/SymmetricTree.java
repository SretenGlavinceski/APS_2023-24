package Tree.BinaryTree;


public class SymmetricTree {
    static boolean isSymmetricTreeR(BNode<Integer> nodeLeft, BNode<Integer> nodeRight) {
        if (nodeLeft == null && nodeRight == null)
            return true;

        if (nodeLeft == null || nodeRight == null)
            return false;

        if (nodeLeft.info != nodeRight.info)
            return false;

        return isSymmetricTreeR(nodeLeft.left, nodeRight.right)
                && isSymmetricTreeR(nodeLeft.right, nodeRight.left);
    }

    static boolean isSymmetricTree(BNode<Integer> root) {
        return isSymmetricTreeR(root, root);
    }


    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>();
        tree.makeRoot(10);
        tree.root.left = new BNode<>(15);
        tree.root.right = new BNode<>(15);

        tree.root.left.left = new BNode<>(20);
        tree.root.left.right = new BNode<>(25);

        tree.root.right.left = new BNode<>(25);
        tree.root.right.right = new BNode<>(20);

        System.out.println(isSymmetricTree(tree.root));
    }
}
