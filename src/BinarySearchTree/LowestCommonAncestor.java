package BinarySearchTree;

//https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/

public class LowestCommonAncestor {
    static BNode<Integer> lowestCommonAncestor(BNode<Integer> root, int node1, int node2) {
        if (root == null)
            return null;

        if (root.info < node1 && root.info < node2)
            return lowestCommonAncestor(root.right, node1, node2);
        else if (root.info > node1 && root.info > node2)
            return lowestCommonAncestor(root.left, node1, node2);
        return root;
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
        System.out.println();
        System.out.println(lowestCommonAncestor(tree.root, 11, 30).info);
    }
}
