package BinarySearchTree;

import Tree.BinaryTree.BNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://www.geeksforgeeks.org/binary-tree-to-binary-search-tree-conversion/

public class BinaryTreeToBST {
    static int index = 0;
    static void inorderR(BNode<Integer> node, List<Integer> list) {
        if (node == null)
            return;

        inorderR(node.left, list);
        list.add(node.info);
        inorderR(node.right, list);
    }

    static List<Integer> inorder(BNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        inorderR(root, list);
        return list;
    }

    static void rearrangeTree(BNode<Integer> node, List<Integer> list) {
        if (node == null)
            return;

        rearrangeTree(node.left, list);
        node.info = list.get(index);
        index++;
        rearrangeTree(node.right, list);
    }

    static void convertToBST(BNode<Integer> root) {
        List<Integer> sortedTree = inorder(root);
        Collections.sort(sortedTree);
        index = 0;
        rearrangeTree(root, sortedTree);
    }

    static void inorderTraversalPrint(BNode<Integer> node) {
        if (node == null) return;
        inorderTraversalPrint(node.left);
        System.out.print(node.info + " ");
        inorderTraversalPrint(node.right);
    }

    public static void main(String[] args) {
        BNode<Integer> root = new BNode<>(10);
        root.left = new BNode<>(7);
        root.left.left = new BNode<>(11);
        root.left.right = new BNode<>(3);
        root.right = new BNode<>(16);
        root.right.left = new BNode<>(5);
        root.right.right = new BNode<>(20);

        inorderTraversalPrint(root);
        convertToBST(root);
        System.out.println( );
        inorderTraversalPrint(root);

    }
}
