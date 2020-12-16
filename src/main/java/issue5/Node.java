package issue5;

public class Node {
    int value;
    Node parent;
    Node left;
    Node right;

    public Node(int value, Node parent) {
        this.value = value;
        this.parent = parent;
    }

    public void addLeft(int value) {
        this.left = new Node(value,this);
    }

    public void addRight(int value) {
        this.right = new Node(value,this);
    }
}
