package BinarySearchTree;

public class AddingNodesGreaterValues {

    static int sum = 0;

    static void modifyBST(BNode<Integer> node) {
        if (node == null)
            return;

        modifyBST(node.right);

        sum = sum + node.info;
        node.info = sum;

        modifyBST(node.left);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(10);
        tree.insert(7);
        tree.insert(3);
        tree.insert(20);
        tree.insert(16);
        tree.insert(5);
        tree.insert(11);
        tree.insert(0);
        tree.insert(50);

        tree.printTree();

        System.out.println();
        modifyBST(tree.root);

        tree.printTree();
    }
}
