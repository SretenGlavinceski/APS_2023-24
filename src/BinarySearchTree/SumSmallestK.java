package BinarySearchTree;

public class SumSmallestK {

    // traverse tree inorder and take first k

    static int count = 0;
    static int sum = 0;
    static void sumK(BNode<Integer> node, int k) {
        if (node == null || count >= k)
            return;

        sumK(node.left, k);

        if (count < k) {
            sum += node.info;
            count++;
        }

        sumK(node.right, k);

    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(8);
        tree.insert(7);
        tree.insert(2);
        tree.insert(10);
        tree.insert(9);
        tree.insert(13);

        tree.printTree();
        System.out.println();

        sumK(tree.root, 4);
        System.out.println(sum);
    }
}
