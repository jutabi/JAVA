package LinkedList;

public class LinkedList {
    Node head;
    public LinkedList(int input) {
        head = new Node(null, input, null);
    }
    public void insert_node(int input) {
        Node node = new Node(null, input, null);
        Node cur_node = head;
        if (head == null) {
            head = node;
        } else {
            while (cur_node.next != null) {
                cur_node = cur_node.next;
            }
            cur_node.next = node;
            node.prev = cur_node;
        }
    }
    public void delete_node(int input) {
        Node cur_node = head;
        if (head.value == input) {
            if (cur_node.next == null) {
                head = null;
            } else {
                head = cur_node.next;
                head.prev = null;
            }
        } else {
            while (cur_node.next != null) {
                cur_node = cur_node.next;
                if (cur_node.value == input) {
                    cur_node.prev.next = cur_node.next;
                    if (cur_node.next != null) {
                        cur_node.next.prev = cur_node.prev;
                    }
                }
            }
        }
    }
    public void print_list() {
        Node cur_node = head;
        while (cur_node != null) {
            System.out.print(cur_node.value + " ");
            cur_node = cur_node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList(0);
        list.insert_node(1);
        list.insert_node(2);
        list.insert_node(1);
        list.insert_node(3);
        list.print_list();

        list.delete_node(1);
        list.print_list();
        list.delete_node(0);
        list.print_list();
        list.delete_node(3);
        list.print_list();
        list.delete_node(2);
        list.print_list();

        list.insert_node(3);
        list.print_list();
    }
}