package linkedlist;

import java.util.HashSet;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }


    private Node createNewNode(int value) {
        return new Node(value);
    }

    public LinkedList(int value) {
        Node node = createNewNode(value);
        head = node;
        tail = node;
        length++;
    }


    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int get(int index) {
        if(index >= length)
            return 0;
        Node temp = head;

        for(int i=0;i<index;i++)
            temp = temp.next;

        return temp.value;
    }

    public boolean set(int index,int value) {
        if (index >= length)
            return false;
        if (length == 1) {
            head.value = value;
            tail.value = value;
            return true;
        }
        else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.value = value;
            return true;
        }
    }

    public boolean insert(int index,int value) {
        // if index = 0 use prepend
        // if index == length use append
        if (index >= length)
            return false;
        Node newNode = createNewNode(value);
        if (length == 1) {
            head.next = newNode;
            tail = newNode;
            length++;
            return true;
        }
        else {
            Node temp = head;
            Node prev = head;
            for (int i = 0; i < index; i++) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = newNode;
            newNode.next = temp;
            length++;
            return true;
        }
    }

    public void prepend(int value) {
        Node newNode = createNewNode(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void append(int value) {
        Node newNode = createNewNode(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void removeFirst() {
        if(length == 0) return;
        if (length == 1) {
            head = null;
            tail = null;
        }
        else {
            Node temp = head;
            head = head.next;
            temp.next = null;
        }
        length--;
    }

    public void remove(int index) {
        if (index < 0 || index >= length)  return;
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == length-1) {
            removeLast();
            return;
        }
        else {
            Node temp = head;
            Node prev = head;
            for (int i = 0; i < index; i++) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
            temp.next = null;
            length--;
        }

    }

    public void removeLast() {
        if(length == 0) return;
        if (length == 1) {
            head = null;
            tail = null;
        }
        else {
            Node temp = head;
            Node prev = head;
            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            tail = prev;
            tail.next = null;
        }
        length--;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;

        for(int i=0;i<length;i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

    }

    public Node removeDuplicates() {
        HashSet<Integer> hashSet = new HashSet<>();
        Node curr = head;
        Node pre = null;
        while (curr != null) {
            if(hashSet.contains(curr.value)) {
                pre.next = curr.next;
            }
            else {
                hashSet.add(curr.value);
                pre = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    public Node findMiddle() {
        if(head == null) return null;
        else if (head.next == null) return head;
        else {
            Node slow = head;
            Node fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        LinkedList myList = new LinkedList(10);
        myList.append(20);
        myList.append(10);
        myList.append(20);
        myList.head = myList.removeDuplicates();
        myList.printList();
    }
}


