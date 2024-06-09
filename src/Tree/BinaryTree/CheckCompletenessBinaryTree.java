package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessBinaryTree {

    static boolean isCompleteTree(BNode<Integer> root) {
        Queue<BNode<Integer>> queue = new LinkedList<>();

        queue.offer(root);
        boolean foundNull = false;

        while (!queue.isEmpty()) {
            BNode<Integer> current = queue.poll();

            if (current == null)
                foundNull = true;
            else {
                if (foundNull)
                    return false;
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        BNode<Integer> root = new BNode<>(1);
        root.left = new BNode<>(2);
        root.right = new BNode<>(3);
        root.left.left = new BNode<>(4);
        root.left.right = new BNode<>(5);
        root.right.left = new BNode<>(6);
        root.right.right = new BNode<>(7);
        root.left.left.left = new BNode<>(8);
        root.left.left.right = new BNode<>(9);
        root.left.right.left = new BNode<>(10);
        root.left.right.right = new BNode<>(11);
        root.right.left.left = new BNode<>(12);
        root.right.left.right = new BNode<>(13);
        root.right.right.left = new BNode<>(14);
        root.right.right.right = new BNode<>(15);
        root.left.left.left.left = new BNode<>(100);
//        root.left.right.right.left = new BNode<>(200);


        System.out.println(isCompleteTree(root));
    }

}
