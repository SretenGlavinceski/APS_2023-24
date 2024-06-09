//package Labs.lab7;
//
//// package aps8;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//class BNode<E> {
//
//    public E info;
//    public BNode<E> left;
//    public BNode<E> right;
//
//    static int LEFT = 1;
//    static int RIGHT = 2;
//
//    public BNode(E info) {
//        this.info = info;
//        left = null;
//        right = null;
//    }
//
//    public BNode() {
//        this.info = null;
//        left = null;
//        right = null;
//    }
//
//    public BNode(E info, BNode<E> left, BNode<E> right) {
//        this.info = info;
//        this.left = left;
//        this.right = right;
//    }
//
//}
//
//class BTree<E extends Comparable<E>> {
//
//    public BNode<E> root;
//
//    public BTree() {
//        root = null;
//    }
//
//    public BTree(E info) {
//        root = new BNode<>(info);
//    }
//
//    public void makeRoot(E elem) {
//        root = new BNode<>(elem);
//    }
//
//    public void makeRootNode(BNode<E> node) {
//        root = node;
//    }
//
//    public BNode<E> addChild(BNode<E> node, int where, E elem) {
//
//        BNode<E> tmp = new BNode<>(elem);
//
//        if (where == BNode.LEFT) {
//            if (node.left != null)  // veke postoi element
//                return null;
//            node.left = tmp;
//        } else {
//            if (node.right != null) // veke postoi element
//                return null;
//            node.right = tmp;
//        }
//
//        return tmp;
//    }
//
//    public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {
//
//        if (where == BNode.LEFT) {
//            if (node.left != null)  // veke postoi element
//                return null;
//            node.left = tmp;
//        } else {
//            if (node.right != null) // veke postoi element
//                return null;
//            node.right = tmp;
//        }
//
//        return tmp;
//    }
//}
//
//public class BinaryTreeSum {
//
//    interface CountSpecificElementsInTree {
//        boolean calculate(String s, int nodeValue, int value);
//    }
//
//    static CountSpecificElementsInTree counter = (s, nodeValue, value) -> {
//        if (s.equals("LEFT"))
//            return nodeValue < value;
//        return nodeValue > value;
//    };
//
//    static int sumSubTreeElements(BNode<Integer> node, int value, String s) {
//        if (node == null)
//            return 0;
//
//        if (counter.calculate(s, node.info, value))
//            return node.info + sumSubTreeElements(node.left, value, s) + sumSubTreeElements(node.right, value, s);
//
//        return sumSubTreeElements(node.left, value, s) + sumSubTreeElements(node.right, value, s);
//    }
//
//    static BNode<Integer> findNode(BNode<Integer> node, int value) {
//        if (node == null)
//            return null;
//
//        if (node.info == value)
//            return node;
//
//        BNode<Integer> temp1 = findNode(node.left, value);
//        BNode<Integer> temp2 = findNode(node.right, value);
//
//        if (temp1 != null)
//            return temp1;
//        return temp2;
//    }
//
//
//    public static void main(String[] args) throws Exception {
//        int i, j, k;
//        int index;
//        String action;
//
//        String line;
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int N = Integer.parseInt(br.readLine());
//
//        ArrayList<BNode<Integer>> nodes = new ArrayList<>();
//        BTree<Integer> tree = new BTree<>();
//
//        for (i = 0; i < N; i++)
//            nodes.add(new BNode<>());
//
//        for (i = 0; i < N; i++) {
//            line = br.readLine();
//            st = new StringTokenizer(line);
//            index = Integer.parseInt(st.nextToken());
//            nodes.get(index).info = Integer.parseInt(st.nextToken());
//            action = st.nextToken();
//            if (action.equals("LEFT")) {
//                tree.addChildNode(nodes.get(Integer.parseInt(st.nextToken())), BNode.LEFT, nodes.get(index));
//            } else if (action.equals("RIGHT")) {
//                tree.addChildNode(nodes.get(Integer.parseInt(st.nextToken())), BNode.RIGHT, nodes.get(index));
//            } else {
//                // this node is the root
//                tree.makeRootNode(nodes.get(index));
//            }
//        }
//
//        int baranaVrednost = Integer.parseInt(br.readLine());
//
//        br.close();
//
//        BNode<Integer> node = findNode(tree.root, baranaVrednost);
//        System.out.printf("%d %d",
//                sumSubTreeElements(node.left, node.info, "LEFT"),
//                sumSubTreeElements(node.right, node.info, "RIGHT"));
//    }
//}