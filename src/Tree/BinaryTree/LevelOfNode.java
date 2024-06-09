package Tree.BinaryTree;

import java.io.IOException;

//https://www.geeksforgeeks.org/get-level-of-a-node-in-a-binary-tree/

public class LevelOfNode {

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
        tree.root.right.right.right.right = new BNode<>(30);

        System.out.println(findDepthNode(tree.root, 30));

    }
}
