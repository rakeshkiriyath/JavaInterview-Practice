package linkedlist;

public class ListNode {

    private int value;

    private ListNode next;

    public ListNode(int value){
        this.value = value;
        this.next = null;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        return null;
    }

    public ListNode prePend(int value) {
        ListNode newNode = new ListNode(value);
        ListNode head = this;
        newNode.next = head;
        return newNode;
    }

    public void append(int value) {
        ListNode newNode = new ListNode(value);
        ListNode tail = this;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;
    }

    public void printList() {
        ListNode head = this;
        while (head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static void main(String args[]) {
        ListNode list1 = new ListNode(1);
        list1.append(5);
        list1.append(6);
        ListNode list2 = new ListNode(2);
        list2.append(10);
        list2.append(20);
        ListNode.mergeTwoLists(list1,list2);
    }
}

