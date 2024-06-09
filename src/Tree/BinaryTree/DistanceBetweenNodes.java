package Tree.BinaryTree;

public class DistanceBetweenNodes {

    static String nodePath(BNode<Integer> node, int value) {
        if (node == null)
            return null;

        if (node.info == value)
            return node.info.toString();

        if (nodePath(node.left, value) != null)
            return node.info + " " + nodePath(node.left, value);

        if (nodePath(node.right, value) != null)
            return node.info + " " + nodePath(node.right, value);

        return null;
    }

    static int distanceBetweenNodes(BNode<Integer> root, BNode<Integer> node1,BNode<Integer> node2) {
        String [] pathFirstNode = nodePath(root, node1.info).split("\\s+");
        String [] pathSecondNode = nodePath(root, node2.info).split("\\s+");

        int i = 0, j = 0, counter = 0;

        // find the first occurrence of same parent node
        while (i < pathFirstNode.length &&
                j < pathSecondNode.length &&
                pathFirstNode[i].equals(pathSecondNode[j])){
            i++;
            j++;
        }

        while ((i < pathFirstNode.length)) {
            counter++;
            i++;
        }

        while ((j < pathSecondNode.length)) {
            counter++;
            j++;
        }

        return counter;
    }

    public static void main(String[] args) {
        BNode<Integer> root = new BNode<>(-1);
        root.left = new BNode<>(-20);
        root.right = new BNode<>(-30);
        root.left.left = new BNode<>(-14);
        root.left.right = new BNode<>(-15);
        root.left.right.left = new BNode<>(-12);
        root.right.left = new BNode<>(-6);
        root.right.right = new BNode<>(-2);
        root.right.right.right = new BNode<>(-11);

        System.out.println(distanceBetweenNodes(root, root.left.right.left, root.right.right.right));
    }
}
