package linkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;
        public Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    private Node clearSoloNode() {
        if(length == 0) return null;
        else if (length == 1) {
            Node temp = head;
            head = null;
            tail = null;
            length--;
            return temp;
        }
        else {
            return null;
        }
    }

    public Node get(int index) {
        if(index < 0 || index >= length) return null;

        Node temp = head;

        for(int i=0;i<index;i++) {
            temp = temp.next;
        }

        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        length++;
    }

    public Node removeFirst() {
        Node soloNode = clearSoloNode();
        if (soloNode != null) {
            return soloNode;
        }
        else {
            Node temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
            length--;
            return temp;
        }
    }

    public Node removeLast() {
        Node soloNode = clearSoloNode();
        if (soloNode != null) {
            return soloNode;
        }
        else {
            Node temp = tail;
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
            length--;
            return temp;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(10);
        doublyLinkedList.append(20);
        doublyLinkedList.append(30);

        doublyLinkedList.printList();
    }
}
