package Node;

public class Node {
    public Node left;
    public Node right;
    public int value, height;

    public Node(int d) {
        value = d;
        height = 1;
        right = null;
        left = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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

    public void displayData()
    {
        System.out.print(value + " ");
    }
}
