package Tree.BinaryTree;

import java.io.IOException;


//https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/

public class CheckSumTree {

    static int subTreeSumR(BNode<Integer> node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return node.info;

        return node.info + subTreeSumR(node.left) + subTreeSumR(node.right);
    }

    static boolean checkEqualSumTreeR(BNode<Integer> node) {
        if (node == null)
            return true;

        if (node.left == null && node.right == null)
            return true;

        int left = subTreeSumR(node.left);
        int right = subTreeSumR(node.right);

        System.out.println(node.info + " = " + left + " + " + right);

        if (node.info != left + right)
            return false;

        return checkEqualSumTreeR(node.left) && checkEqualSumTreeR(node.right);
    }

    public static void main(String[] args) throws IOException {
        BTree<Integer> tree = new BTree<>();
        tree.root = new BNode<>(48);
        tree.root.left = new BNode<>(14);
        tree.root.right = new BNode<>(10);
        tree.root.left.left = new BNode<>(4);
        tree.root.left.right = new BNode<>(5);
        tree.root.right.right = new BNode<>(5);
        tree.root.left.right.left = new BNode<>(1);
        tree.root.left.right.right = new BNode<>(4);
        tree.root.right.right.left = new BNode<>(1);
        tree.root.right.right.right = new BNode<>(2);
        tree.root.right.right.right.left = new BNode<>(1);
        tree.root.right.right.right.right = new BNode<>(1);

        System.out.println(checkEqualSumTreeR(tree.root));

    }
}
