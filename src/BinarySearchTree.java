

public class BinarySearchTree {
    static int height = -1;


    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }

         public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
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


    static void printInorder(Node node) {
        if (node == null)
            return;


        printInorder(node.left);


        System.out.print(node.key + " ");


        printInorder(node.right);
    }


    static void printPreorder(Node node) {
        if (node == null)
            return;


        System.out.print(node.key + " ");


        printPreorder(node.left);


        printPreorder(node.right);
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
                return root.left;else{
                root.key = maxValue(root.left);
                root.left = deleteRec(root.left, root.key);
            }

        }
        return root;
    }
    static int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    static int maxValue(Node root) {
        int maxv = root.key;
        while (root.right != null) {
            maxv = root.right.key;
            root = root.right;
        }
        return maxv;
    }


    static int maxDepth(Node node) {
        if (node == null)
            return -1;
        else {

            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);


            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    static int right_height(Node node) {
        int ht = 0;
        while (node != null) {
            ht++;
            node = node.right;
        }


        return ht;
    }

    static int left_height(Node node) {
        int ht = 0;
        while (node != null) {
            ht++;
            node = node.left;
        }


        return ht;
    }

    static int TotalNodes(Node root) {


        if (root == null)
            return 0;


        int lh = left_height(root);
        int rh = right_height(root);


        if (lh == rh)
            return (1 << lh) - 1;


        return 1 + TotalNodes(root.left)
                + TotalNodes(root.right);
    }


    static int getLeafCount(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        else
            return getLeafCount(node.left) + getLeafCount(node.right);
    }

    static int findDepth(Node root, int x) {


        if (root == null)
            return -1;


        int dist = -1;

        if ((root.key == x) ||


                (dist = findDepth(root.left, x)) >= 0 ||


                (dist = findDepth(root.right, x)) >= 0)


            return dist + 1;

        return dist;
    }


    static int findHeightUtil(Node root, int x) {


        if (root == null) {
            return -1;
        }

        int leftHeight = findHeightUtil(root.left, x);

        int rightHeight = findHeightUtil(root.right, x);


        int ans = Math.max(leftHeight, rightHeight) + 1;


        if (root.key == x)
            height = ans;

        return ans;
    }


    static int findHeight(Node root, int x) {


        findHeightUtil(root, x);


        return height;
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
