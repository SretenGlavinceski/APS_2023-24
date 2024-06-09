package Tree.BinaryTree;

//https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/

public class CheckBinarySearchTree {
    static boolean isBST_R(BNode<Integer> node, int max, int min) {
        if (node == null)
            return true;

        if (node.info >= max || node.info <= min)
            return false;

        return isBST_R(node.left, node.info, min) && isBST_R(node.right ,max, node.info);
    }
    static boolean isBST(BNode<Integer> node) {
        return isBST_R(node.left, node.info, Integer.MIN_VALUE) &&
                isBST_R(node.right, Integer.MAX_VALUE, node.info);
    }

    public static void main(String[] args) {
        BNode<Integer> root = new BNode<>(10);
        root.left = new BNode<>(5);
        root.left.left = new BNode<>(3);
        root.left.right = new BNode<>(7);
        root.right = new BNode<>(16);
        root.right.left = new BNode<>(13);
        root.right.right = new BNode<>(20);

        System.out.println(isBST(root));
    }

}
