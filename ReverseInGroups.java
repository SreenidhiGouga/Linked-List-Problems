
public class ReverseInGroups
{
    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    public Node head;
    public void insertBeg(int data)
    {
        Node newnode=new Node(data);
        newnode.next=head;
        head=newnode;
        return;
        
    }
    public void insertEnd(int data)
    {
        
        if(head==null)
        {
            insertBeg(data);
            return;
        }
        Node newnode=new Node(data);
        Node current=head;
        while(current.next!=null)
        {
            current=current.next;
        }
        current.next=newnode;
        
    }
    public Node revgroup(Node head, int k) {
    if (head == null || k <= 1)
        return head;

    Node current = head;
    Node prev = null;
    Node next = null;

    // Check if there are at least k nodes
    Node check = head;
    int count = 0;
    while (count < k && check != null) {
        check = check.next;
        count++;
    }
    if (count < k)
        return head;  // Not enough nodes to reverse, return head

    // Reverse k nodes
    count = 0;
    while (current != null && count < k) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
        count++;
    }

    // head is now the tail of the reversed group
    // Connect it with the next group's reversed head
    if (next != null)
        head.next = revgroup(next, k);

    return prev;  // New head after reversal
    }
    public void display()
    {
        Node current=head;
        if(head==null)
        {
            System.out.println("No elements");
            return;
        }
        while(current!=null)
        {
            System.out.print(current.data+"->");
            current=current.next;
        }
        System.out.println("null");
        
    }
    
	public static void main(String[] args) {
		ReverseInGroups m=new ReverseInGroups();
		m.insertBeg(1);
		m.insertEnd(2);
		m.insertEnd(4);
		m.insertEnd(5);
		m.display();
		m.head=m.revgroup(m.head,2);
		m.display();
	}

//output
//1->2->4->5->null
//2->1->5->4->null
}
