package UnbalancedTree;
import Node.Node;
import Interfaces.BinarySearchTree;

public class UnbalancedBinaryTree implements BinarySearchTree {
    private Node root;

    public UnbalancedBinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void insert(int i) {
        root = insert(root, i);
    }

    public Node insert(Node node, int value) {
        if (node == null)
            return new Node(value);
        else
            if (value <= node.value)
                node.left = insert(node.left, value);

            else
                node.right = insert(node.right, value);
        return node;
    }


    @Override
    public void delete(int value) {
        if (isEmpty())
            System.out.println("Tree is empty!");
        else if (!search(value))
            System.out.println("Sorry " + value + " is not present");
        else
            root = delete(root, value);
    }

    private Node delete(Node root, int value) {
        Node p, p2, n;
        if (value == root.getValue()) {
            Node lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;
            else if (lt == null) {
                p = rt;
                return p;
            } else if (rt == null) {
                p = lt;
                return p;
            } else {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            }
        }
        if (value < root.getValue()) {
            n = delete(root.getLeft(), value);
            root.setLeft(n);
        } else {
            n = delete(root.getRight(), value);
            root.setRight(n);
        }
        return root;
    }

    @Override
    public boolean search(int value){
        return search(root, value);
    }

    private boolean search(Node root, int value) {
        boolean status = false;
        while ((root != null) && !status) {
            int root_value = root.getValue();
            if (value < root_value)
                root = root.getLeft();
            else if(value > root_value)
                root = root.getRight();
            else {
                status = true;
                break;
            }
            status = search(root, value);
        }
        return status;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            node.displayData();
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    int max(int a, int b) {
        return Math.max(a, b);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void balance() {
        root = balance(root);
    }

    public Node balance(Node node){
        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

}