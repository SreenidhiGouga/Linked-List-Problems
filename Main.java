class SinglyLinkedList{
    //class- Node
    static class Node{
        
        int data;//4 
        Node next;//12
        Node(int data){
            this.data=data;
        }
    }   
    //head 
    private Node head=null;
    //insertAtBeg()
    public void insertAtBeg(int data){//5
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
}
    //insertAtEnd()
    public void insertAtEnd(int data){
        Node newNode=new Node(data);
        Node temp=head;
        while(temp.next!=null)
            temp=temp.next;
        temp.next=newNode;
    }
  
    // deleteAtBeg()
    public void deleteAtBeg() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // deleteAtEnd()
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        temp.next = null;
    }

    //display
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
    }
}
    
    
 public class Main{   
    public static void main(String[] args){
        SinglyLinkedList sl=new SinglyLinkedList();
       sl.insertAtBeg(5); //1000
       sl.insertAtBeg(6);//2000
       sl.insertAtBeg(7);//3000
       sl.insertAtBeg(8);//4000
       sl.display();//8->7->6->5->null
       sl.insertAtEnd(9);//5000
       System.out.println();
       sl.display();//8->7->6->5->9->null
       System.out.println();
       sl.deleteAtBeg();
       sl.display(); // 7->6->5->9->null
       System.out.println();
       sl.deleteAtEnd();
       sl.display(); // 7->6->5->null

    }
}