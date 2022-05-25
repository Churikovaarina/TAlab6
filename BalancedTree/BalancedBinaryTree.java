package BalancedTree;

import Interfaces.BinarySearchTree;
import Node.Node;

public class BalancedBinaryTree implements BinarySearchTree {
    Node root;

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

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    @Override
    public void insert(int i) {
        root = insert(root,i);
    }

    Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.value)
            node.left = insert(node.left, key);
        else if (key > node.value)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + max(height(node.left),
                height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.value)
            return rightRotate(node);

        if (balance < -1 && key > node.right.value)
            return leftRotate(node);

        if (balance > 1 && key > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    Node minValueNode(Node node) {
        Node current = node;

        while (current.left != null)
            current = current.left;

        return current;
    }

    @Override
    public void delete(int i) {
        root = deleteNode(root, i);
    }

    @Override
    public void balance() {
        System.out.println("already balanced!");
    }

    Node deleteNode(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.value)
            root.left = deleteNode(root.left, key);

        else if (key > root.value)
            root.right = deleteNode(root.right, key);

        else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                if (temp == null) {
                    temp = root;
                    root = null;
                }
                else
                    root = temp;
            }
            else {
                Node temp = minValueNode(root.right);

                root.value = temp.value;

                root.right = deleteNode(root.right, temp.value);
            }
        }

        if (root == null)
            return root;

        root.height = max(height(root.left), height(root.right)) + 1;

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

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

}