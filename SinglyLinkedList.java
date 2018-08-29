import java.util.Scanner;

public class SinglyLinkedList
{
	
	public static void main(String args[])
	{

		LinkedList ll=new LinkedList();
		ll.chooseOps();	
	}
} 

class ListNode
{
	int data;
	ListNode next;

	public ListNode(int datavalue)
	{
		this.data=datavalue;
	}
}

class LinkedList
{
	ListNode head;
	int listLength;

	public LinkedList()
	{
		head=null;
		listLength=0;
	}

	public ListNode getHead()
	{
		return head;
	}

	public int getLength()
	{

		return listLength;
	}

	public void printLinkedList()
	{
		ListNode currNode=head;
		if(head==null)
		{
			System.out.println("********************** NO NODES in the list*******************************");
			return;
		}
		System.out.println("********************Printing LinkedList**********************");
		System.out.println("			Number of nodes : "+listLength+" Head Node : "+head.data);
		while(currNode !=null)
		{
			System.out.print(currNode.data+" ");
			currNode=currNode.next;
		}
		System.out.println();
		System.out.println("***********************Printed LinkdeList************************");
		
	}

	public void insert(int data)
	{
		if(head==null)
		{
			ListNode node=new ListNode(data);
			listLength++;
			head=node;
		}

		else
		{
			System.out.println("Enter the position... Enter -1 to insert at the end ");
			Scanner ss=new Scanner(System.in);
			int pos=ss.nextInt();
			if(pos>listLength+1 || (pos<1 && pos!=-1))
			{
				System.out.println(">>>>>>>>>>>Specified Position of the node can not exit<<<<<<<<<<<<");
				return;
			}

			else if(pos==-1 || pos==listLength+1)
			{
				ListNode node=new ListNode(data);
				node.next=null;			
				ListNode currnode=head;
				while(currnode.next!=null)
				{
					currnode=currnode.next;
				}
				currnode.next=node;
				listLength++;
			}
			else
			{
				ListNode node=new ListNode(data);
				int position=1;
				ListNode currnode=head;
				while(position<pos-1)
				{
					currnode=currnode.next;
					position++;
				}
				node.next=currnode.next;
				currnode.next=node;
				listLength++;		
			}
		}
	}

	public void remove(int position)
	{
		ListNode currnode=head;
		if(head==null)
		{
			System.out.println("No Nodes in the list to delete");
			return;
		}
		if(currnode!=null && position==1)
		{
			head=head.next;
		}
		else if(position ==-1)
		{
			while(currnode.next.next!=null)
			{
				System.out.println(currnode.data);
				currnode=currnode.next;
			}	
			currnode.next=null;
		}
		else
		{
			int pos=1;
			while(pos<position-1)
			{
				System.out.println("Printing currnode data "+currnode.data);	
				currnode=currnode.next;
				pos++;
			}
			currnode.next=currnode.next.next;
		}			
		listLength--;
	}

	public void removeMatched(int data)
	{
		ListNode currnode=head;
		if(head==null)
		{
			System.out.println("********No node in the list***************");
			return;
		}
		else if(currnode.data==data)
		{
			head=head.next;
			listLength--;		
		}
		
		else
		{
			int x=1;
			while(currnode.next.data!=data && x<listLength )
			{
				currnode=currnode.next;
				x++;
			if(currnode.next.data==data)
			}
			{
				currnode.next=currnode.next.next;
				listLength--;	
			}
			else
			{
				System.out.println("No match found");
			}
		}
	}

	public void chooseOps()
	{
		System.out.println("Press 1 to continue");	
		System.out.println("Press 0 to exit");
		
		Scanner s=new Scanner(System.in);
		int choice=s.nextInt();

		if(choice == 0)
		{
			System.exit(0);
		}		
		while(choice!=0)
			{
				System.out.println("choose the operation you want to perform...");
				System.out.println("Press 0 to exit");
				System.out.println("Press 1 to insert an element to the LinkedList");
				System.out.println("Press 2 to delete the element having specified position");
				System.out.println("Press 3 to delete node with given data");
				
				Scanner ss=new Scanner(System.in);
				choice=ss.nextInt();

				switch(choice)
				{
					case 1 : System.out.println("Enter the data ");
						 int data=ss.nextInt();
						 insert(data);	
						 printLinkedList();
						 break;
					case 2 :  System.out.println("Enter the position..Enter 1 for beginning and Enter -1 to delete 							  the last node ");
						 int pos=ss.nextInt();
						 remove(pos);	
						 printLinkedList();
						 break;
					case 3 :  System.out.println("Enter the data you want to delete");
						 int datatodelete=ss.nextInt();
						 removeMatched(datatodelete);	
						 printLinkedList();
						 break;
					case 0 : System.exit(0);
				}
				
			}		
	}

}


