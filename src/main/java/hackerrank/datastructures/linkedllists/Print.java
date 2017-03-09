package hackerrank.datastructures.linkedllists;

/**
 * Created by admin on 08/03/2017.
 */
public class Print {
    static Node InsertAtHead(Node head, int x) {
        Node newNode = new Node();
        newNode.data = x;
        if(head == null) return newNode;
        newNode.next = head;
        return newNode;
    }
    static Node InsertAtTail(Node head, int data) {
        Node newNode = new Node();
        newNode.data = data;
        if(head == null) return newNode;
        Node currentNode = head;
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        return head;
    }
    static void Print(Node head) {
        Node next = head;
        while (next != null) {
            System.out.println(next.data);
            next=next.next;
        }
    }
    public static void main(String[] args) {
        Node node1 = new Node();
        node1.data = 1;
        Node node2 = new Node();
        node1.next = node2;
        node2.data = 2;
        Node node3 = new Node();
        node2.next = node3;
        node3.data = 3;
        InsertAtTail(node1, 4);
        Print(node1);
        Print(InsertAtTail(null, 5));
        Print(InsertAtHead(null, 6));
        Print(InsertAtHead(node1, 7));
    }
}
