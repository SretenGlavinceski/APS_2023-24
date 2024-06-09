package Tree.BinaryTree;

//https://www.geeksforgeeks.org/check-if-two-trees-are-mirror/

public class CheckMirrorTrees {

    static boolean areMirror(BNode<Integer> firstTree, BNode<Integer> secondTree){
        if (firstTree == null && secondTree == null)
            return true;

        if (firstTree == null || secondTree == null)
            return false;

        return firstTree.info == secondTree.info &&
                areMirror(firstTree.left, secondTree.right) &&
                areMirror(firstTree.right, secondTree.left);
    }

    public static void main(String[] args) {
        BTree<Integer> tree1 = new BTree<>(1);
        tree1.root.left = new BNode<>(2);
        tree1.root.right = new BNode<>(3);
        tree1.root.left.left = new BNode<>(4);
        tree1.root.left.right = new BNode<>(5);

        BTree<Integer> tree2 = new BTree<>(1);
        tree2.root.left = new BNode<>(3);
        tree2.root.right = new BNode<>(2);
        tree2.root.right.left = new BNode<>(5);
        tree2.root.right.right = new BNode<>(4);

        System.out.println(areMirror(tree1.root, tree2.root));
    }
}
