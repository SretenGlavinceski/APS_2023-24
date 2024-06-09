package BinarySearchTree;

public class CheckForBalancedBinaryTree {

    static int isBalanced(BNode<Integer> node) {
        if (node == null)
            return 0;
        int leftHalf = isBalanced(node.left);

        if (leftHalf == -1)
            return -1;

        int rightHalf = isBalanced(node.right);

        if (rightHalf == -1)
            return -1;

        if (Math.abs(leftHalf - rightHalf) > 1)
            return -1;
        else
            return Math.max(leftHalf, rightHalf) + 1;
    }

    public static void main(String[] args) {
        BNode<Integer> root = new BNode<>(10);
        root.left = new BNode<>(7);
        root.left.left = new BNode<>(4);
        root.left.right = new BNode<>(9);
        root.right = new BNode<>(16);
        root.right.left = new BNode<>(15);
        root.right.right = new BNode<>(20);
        root.right.right.left = new BNode<>(50);
        root.right.right.left.right = new BNode<>(100);

        if (isBalanced(root) == -1)
            System.out.println("NOT BALANCED TREE");
        else
            System.out.println("BALANCED TREE");
    }
}
