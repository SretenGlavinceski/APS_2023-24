package Tree.BinaryTree;

public class LargestSubtree {

    static int sumSubTree(BNode<Integer> node) {
        if (node == null)
            return 0;

        return node.info + sumSubTree(node.left) + sumSubTree(node.right);
    }

    static int maxSumSubTree(BNode<Integer> node) {
        if (node == null)
            return Integer.MIN_VALUE;

        int maxNodeValue = sumSubTree(node);

        maxNodeValue = Math.max(maxSumSubTree(node.left), maxNodeValue);
        maxNodeValue = Math.max(maxSumSubTree(node.right), maxNodeValue);

        return maxNodeValue;
    }

    public static void main(String[] args) {
        BNode<Integer> root = new BNode<>(-1);
        root.left = new BNode<>(-2);
        root.right = new BNode<>(-3);
        root.left.left = new BNode<>(-4);
        root.left.right = new BNode<>(-5);
        root.left.right.left = new BNode<>(-12);
        root.right.left = new BNode<>(-6);
        root.right.right = new BNode<>(-2);
        root.right.right.right = new BNode<>(-1);

        System.out.println(maxSumSubTree(root));
    }
}
