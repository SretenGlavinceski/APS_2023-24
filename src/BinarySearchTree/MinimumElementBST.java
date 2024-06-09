package BinarySearchTree;

//https://www.geeksforgeeks.org/find-the-minimum-element-in-a-binary-search-tree/

public class MinimumElementBST {

    static int minElement(BNode<Integer> node) {
        if (node == null)
            return -1;

        while (node.left != null) {
            node = node.left;
        }

        return node.info;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(124);
        tree.insert(5);
        tree.insert(33);
        tree.insert(2);
        tree.insert(243);
        tree.insert(233);
        tree.insert(144);
        tree.insert(56);
        tree.insert(12);

        tree.printTree();
        System.out.println("Minimum element is: " + minElement(tree.root));
    }
}
