

public class BinarySearchTree {

    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }

    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {


        if (root == null) {
            root = new Node(key);
            return root;
        }


        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);


        return root;
    }

    static void printPostorder(Node node) {
        if (node == null)
            return;


        printPostorder(node.left);


        printPostorder(node.right);


        System.out.print(node.key + " ");
    }

    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                root.key = maxValue(root.left);
                root.left = deleteRec(root.left, root.key);
            }

        }
        return root;
    }

    static int maxValue(Node root) {
        int maxv = root.key;
        while (root.right != null) {
            maxv = root.right.key;
            root = root.right;
        }
        return maxv;
    }

    static int countChildren(Node head) {
        if (head == null) return 0;
        return ((head.left == null) ? 0 : countChildren(head.left) + 1) + ((head.right == null) ? 0 : countChildren(head.right) + 1);
    }

    static int temp = 0;

    static void resetTemp() {
        temp = 0;
    }

    static int countAllChildren(Node node) {
        if (node == null)
            return 0;
        temp = temp + countChildren(node);
        countAllChildren(node.left);
        countAllChildren(node.right);
        return temp;
    }

}
