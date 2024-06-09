package Tree.BinaryTree;

public class CheckPerfectBinaryTree {

    static int getTreeHeight(BNode<Integer> node) {
        if (node == null)
            return 0;

        int leftTreeHeight = getTreeHeight(node.left);
        int rightTreeHeight = getTreeHeight(node.right);

        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }

    static boolean isPerfectTree(BNode<Integer> node, int height, int level) {
        if (node == null)
            return true;

        if (node.left == null && node.right == null)
            return height == level + 1;

        if (node.left == null || node.right == null)
            return false;

        return isPerfectTree(node.left, height, level + 1)
                && isPerfectTree(node.right, height, level + 1);
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

        System.out.println(isPerfectTree(tree.root, getTreeHeight(tree.root), 0));

    }
}
