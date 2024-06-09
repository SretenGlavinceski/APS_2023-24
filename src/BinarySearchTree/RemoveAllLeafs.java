package BinarySearchTree;

//https://www.geeksforgeeks.org/remove-leaf-nodes-binary-search-tree/

public class RemoveAllLeafs {
    static void removeAllLeafs(BNode<Integer> node) {
        if (node == null)
            return;

        if (node.left != null && isLeaf(node.left))
            node.left = null;

        if (node.right != null &&isLeaf(node.right))
            node.right = null;

        removeAllLeafs(node.left);
        removeAllLeafs(node.right);
    }

    static boolean isLeaf(BNode<Integer> node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(20);
        tree.insert(15);
        tree.insert(13);
        tree.insert(21);
        tree.insert(19);
        tree.insert(17);
        tree.insert(14);
        tree.insert(12);
        tree.insert(10);
        tree.insert(11);
        tree.insert(22);
        tree.insert(28);
        tree.insert(26);
        tree.insert(30);

        tree.printTree();
        removeAllLeafs(tree.root);
        System.out.println();
        tree.printTree();
        System.out.println();
    }
}
