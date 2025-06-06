
public class DeleteKth
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
    public void deletekth(int k)
	{
	    Node current=head;
	    int count=1;
	    while(current!=null && current.next!=null)
	    {
	        if((count+1)%k==0)
	        {
	            current.next=current.next.next;
	            count++;
	            
	        }
	        else
	        {
	            current=current.next;
	            count++;
	        }
	        
	    }
	}
    
	public static void main(String[] args) {
		DeleteKth m=new DeleteKth();
		m.insertBeg(1);
		m.insertEnd(2);
		m.insertEnd(4);
		m.insertEnd(5);
		m.display();
	  m.deletekth(2);
		m.display();
	}
}

//output:
 1->2->40>5->null
 1->4->null

