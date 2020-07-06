package LinkedList;

public class Node {
    Node prev;
    int value;
    Node next;
    public Node(Node left, int value1, Node right) {
        prev = left;
        value = value1;
        next = right;
    }
}