package BinarySearchTree;

// The second largest element is second last element in inorder traversal
// https://www.geeksforgeeks.org/second-largest-element-in-binary-search-tree-bst/
public class SecondLargestElement {

    static int index = 0;

    static void inorder(BNode<Integer> node, int[] array) {
        if (node == null)
            return;

        inorder(node.left, array);
        array[index] = node.info;
        index++;
        inorder(node.right, array);
    }

    static int[] inorderTraversal(BNode<Integer> root, int n) {
        int[] array = new int[n];
        inorder(root, array);
        return array;
    }

    static int secondLargest(BNode<Integer> root, int n) {
        int[] array = inorderTraversal(root, n);
        return array[array.length - 2];
    }

    public static void main(String[] args) {
        BNode<Integer> root = new BNode<>(10);
        root.left = new BNode<>(7);
        root.left.left = new BNode<>(4);
        root.left.right = new BNode<>(9);
        root.right = new BNode<>(16);
        root.right.left = new BNode<>(15);
        root.right.right = new BNode<>(20);

        System.out.println("Second largest: " + secondLargest(root, 7));
    }
}
