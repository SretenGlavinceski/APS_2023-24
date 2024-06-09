package Tree.BinaryTree;

import java.io.IOException;

public class CheckCousinNodes {

    static BNode<Integer> findR(BNode<Integer> node, int value) {
        if (node == null)
            return null;

        if (node.info == (value))
            return node;

        BNode<Integer> left = findR(node.left, value);
        BNode<Integer> right = findR(node.right, value);

        if (left != null && left.info == (value))
            return left;

        if (right != null && right.info == (value))
            return right;

        return null;
    }

    static BNode<Integer> find(BNode<Integer> root, int value) {
        return findR(root, value);
    }

    static int depthR(BNode<Integer> node, int value, int depth) {
        if (node == null)
            return -1;

        if (node.info.equals(value))
            return depth;

        int leftDepth = depthR(node.left, value, depth + 1);
        int rightDepth = depthR(node.right, value, depth + 1);

        return Math.max(leftDepth, rightDepth);
    }

    static int findDepthNode(BNode<Integer> node, int value) {
        return depthR(node, value, 0);
    }

    static BNode<Integer> parentNode(BNode<Integer> node, BNode<Integer> lookFor) {
        if (node == null)
            return null;

        if (node.left != null && node.left.info == lookFor.info)
            return node;

        if (node.right != null && node.right.info == lookFor.info)
            return node;

        if (node.left != null && parentNode(node.left, lookFor) != null)
            return parentNode(node.left, lookFor);
        else if (node.right != null && parentNode(node.right, lookFor) != null)
            return parentNode(node.right, lookFor);

        return null;
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

//        System.out.println(find(tree.root, 14).info);
//        System.out.println(findDepthNode(tree.root, 5));
        System.out.println(parentNode(tree.root, tree.root.left.right.left).info);
    }
}
