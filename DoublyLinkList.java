import java.util.Scanner;

public class DoublyLinkList
{
	public static void main(String args[])
	{
		DLinklist ll=new DLinklist();
		ll.chooseOps();			
	}
}


class DLinklist
{
	DLLNode head;
	int listLength;

	public DLinklist()
	{
		head=null;
		listLength=0;
	}

	public DLLNode getHead()
	{
		return head;
	}

	public int getLength()
	{

		return listLength;
	}

	public void insert(int data)
	{
		if(head==null)
		{
			DLLNode dllnode=new DLLNode(data);
			listLength++;
			head=dllnode;	
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
				DLLNode node=new DLLNode(data);		
				DLLNode currnode=head;
				while(currnode.next!=null)
				{
					currnode=currnode.next;
				}
				node.prev=currnode;
				currnode.next=node;
				listLength++;
			}
			else
			{
				DLLNode node=new DLLNode(data);
				int position=1;
				DLLNode currnode=head;
				
				if(pos==1)
				{
					head.prev=node;
					node.next=head;
					head=node;
					listLength++;	
				}				
				else
				{
					while(position<pos-1)
					{
						currnode=currnode.next;
						position++;
					}
					node.prev=currnode;
					node.next=currnode.next;
					currnode.next.prev=node;
					currnode.next=node;
					listLength++;	
				}
					
			}
		}
		
	}

	public void printLinkedList()
	{
		DLLNode currNode=head;
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

	public void remove(int position)
	{
		DLLNode currnode=head;
		if(head==null)
		{
			System.out.println("No Nodes in the list to delete");
			return;
		}
		if(currnode!=null && position==1)
		{
			head=head.next;
		}
		else if(position ==-1 || position==listLength)
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
			currnode.next.prev=currnode;
		}			
		listLength--;
	}

	public void removeMatched(int data)
	{
		DLLNode currnode=head;
		if(head==null)
		{
			System.out.println("********No node in the list***************");
			return;
		}
		else if(currnode.data==data)
		{
			head=head.next;
			head.prev=null;
			listLength--;		
		}
		
		else
		{
			int x=1;
			while(currnode.next.data!=data && x<listLength )
			{
				currnode=currnode.next;
				x++;
			}
			if(currnode.next.data==data)
			{
				currnode.next.prev=currnode;
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
					case 2 :  System.out.println("Enter the position..Enter 1 for beginning and Enter -1 to delete the last node ");
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

class DLLNode
{
	int data;
	DLLNode prev;
	DLLNode next;
	
	public DLLNode(int data)
	{
		this.data=data;
		prev=null;
		next=null;
	}
}


