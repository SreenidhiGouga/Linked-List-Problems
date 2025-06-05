class LinkedList {
    // class - Node
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    // head
    private Node head = null;

    // insertAtBeg()
    public void insertAtBeg(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // insertAtEnd()
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    
    // insertAtMid()
    public void insertAtMid(int data) {
        Node newNode = new Node(data);
        if (head == null || head.next == null) {
            insertAtEnd(data);
            return;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        newNode.next = slow.next;
        slow.next = newNode;
    }
    
    public void printMiddle() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.data);
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }
}

public class PrintMiddleInList {
    public static void main(String[] args) {
        LinkedList sl = new LinkedList();

        System.out.println("After inserting at begining:");
        sl.insertAtBeg(5);
        sl.insertAtBeg(6);
        sl.insertAtBeg(7);
        sl.insertAtBeg(8);
        sl.display(); // 8->7->6->5->null
        System.out.println();

        System.out.println("After inserting at end:");
        sl.insertAtEnd(9);
        sl.display(); // 8->7->6->5->9->null
        
        System.out.println("\nRetrieve middle element:");
        sl.printMiddle(); 

        
    }
}

