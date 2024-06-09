package BinarySearchTree;

//https://www.geeksforgeeks.org/shortest-distance-between-two-nodes-in-bst/

public class DistanceBetweenTwoNodes {

    static BNode<Integer> findLowestCommonAncestor(BNode<Integer> root, int node1, int node2) {
        if (root == null)
            return null;

        if (root.info < node1 && root.info < node2)
            return findLowestCommonAncestor(root.right, node1, node2);
        else if (root.info > node1 && root.info > node2)
            return findLowestCommonAncestor(root.left, node1, node2);
        return root;
    }

    static int findDistance(BNode<Integer> root, int node) {
        if (root == null)
            return -1;

        if (root.info == node)
            return 0;

        if (root.info > node)
            return 1 + findDistance(root.left, node);
        else
            return 1 + findDistance(root.right, node);
    }

    static int findDistanceBetweenNodes(BNode<Integer> root, int node1, int node2) {
        BNode<Integer> node = findLowestCommonAncestor(root, node1, node2);

        if (node == null)
            return -1;

        int leftNodePath = findDistance(node, node1);
        int rightNodePath = findDistance(node, node2);

        return leftNodePath + rightNodePath;
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
        System.out.println(findDistanceBetweenNodes(tree.root, 14, 26));
    }
}
