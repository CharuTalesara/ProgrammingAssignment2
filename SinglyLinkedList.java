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

				
				if(pos==1)
				{
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
					node.next=currnode.next;
					currnode.next=node;
					listLength++;				
				}						
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
			while( currnode.next.next!=null)
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


	public void sortEvenOdd()
	{
		if(head==null)
		{
			System.out.println("********No node in the list to sort***************");
			return;
		}
		else if(listLength==1)
		{
			return;
		}
		else
		{			
			for(int lllength=listLength;lllength>1;lllength--)
			{
				ListNode currnode=head;
				while(currnode.next!=null)
				{
					if(currnode.data%2!=0)
					{
						int temp=currnode.data;
						currnode.data=currnode.next.data;
						currnode.next.data=temp;
					}
					currnode=currnode.next;
				}
			}
		}
	}

	public void sortLL()
	{
		if(head==null)
		{
			System.out.println("********No node in the list to sort***************");
			return;
		}
		else if(listLength==1)
		{
			return;
		}
		else
		{			
			for(int lllength=listLength;lllength>1;lllength--)
			{
				ListNode currnode=head;
				while(currnode.next!=null)
				{
					if(currnode.data>currnode.next.data)
					{
						int temp=currnode.data;
						currnode.data=currnode.next.data;
						currnode.next.data=temp;
					}
					currnode=currnode.next;
				}
			}
		}
	}

	public int getPos(int nodData)
	{
		ListNode currnode=head;
		int pos=1;
		while(currnode.next!=null)
		{
			if(currnode.data==nodData)
			{
				return pos;
			}
			pos++;
			currnode=currnode.next;
		}
		return pos;
		
	}	

	public int getNode(int endpos)
	{
		ListNode currnode=head;
		int pos=listLength+1-endpos;
		int nodedata=-1;
 		if(endpos>listLength || endpos<1)
		{
			System.out.println("******WRONG POSITION ENTERED**********");
		}
		else
		{
			int count=1;
			while(count<pos)
			{
				currnode=currnode.next;
				count++;
			}
			nodedata=currnode.data;
		}
		return	nodedata;
	}		

	public void removePos(int position)
	{
		ListNode currnode=head;
		if(head==null)
		{
			System.out.println("********No node in the list***************");
			return;
		}

		if(position>listLength || position<1)
		{
			System.out.println("*************Specified position does not exist********************");
			return;
		}		
				

		
		if(position>1)
		{
			int pos=1;
			while(pos<position-1)
			{
				currnode=currnode.next;
				pos++;
			}
			currnode.next=currnode.next.next;
		}
		else
		{
			head=head.next;
		}
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
			}
			if(currnode.next.data==data)
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

	public void reverse()
	{
		ListNode currnode=head;
		if(head==null)
		{
			System.out.println("********No node in the list***************");
			return;
		}
		else if(listLength==1)
		{
			return;
		}
		else if(listLength==2)
		{
			ListNode temp=currnode;
			currnode.next.next=head;
			head=currnode.next;
			currnode.next=null;
		}
		else
		{
			ListNode prev=null;
			ListNode next=null;
			while(currnode!=null)
			{
				next=currnode.next;
				currnode.next=prev;
				prev=currnode;
				currnode=next;
			}
			head=prev;	
		}
		
	}
		
	
	public void rotate(int by)
	{
		ListNode firstnode=head;
		ListNode currnode=head;
		if(head==null)
		{
			System.out.println("********No node in the list***************");
			return;
		}
		else if(by>listLength || by<1)
		{
			System.out.println("Wrong value of entered");
		}
		else if(listLength==1)
		{
			return;
		}
		else
		{
			for(int i=1;i<=by;i++)
			{
				firstnode=firstnode.next;
			}
			System.out.println("First Node : "+firstnode.data);
			head=firstnode;
			ListNode lastnode=firstnode;
			while(lastnode.next!=null)
			{
				lastnode=lastnode.next;
			}
			System.out.println("Last Node "+lastnode.data);
			int count=1;
			while(currnode!=firstnode)
			{
				ListNode node=new ListNode(currnode.data);
				System.out.println(node.data);
				lastnode.next=node;
				lastnode=node;
				currnode=currnode.next;				
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
				System.out.println("Press 4 to delete data with a specified position");
				System.out.println("Press 5 to sort the linkedlist");
				System.out.println("Press 6 to get position of a given element");
				System.out.println("Press 7 to print linklist");
				System.out.println("Press 8 to get nth element from the end");
				System.out.println("Press 9 to sort the linklist as even odd");
				System.out.println("Press 10 to reverse the existing linklist");
				System.out.println("Press 11 to rotate the linklist clockwise");
				
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
					case 4 : System.out.println("Enter the position of the node you want to delete");
						 int nodetodelete=ss.nextInt();
						 removePos(nodetodelete);	
						 printLinkedList();
						 break;
					case 5 : sortLL();	
						 printLinkedList();
						 break;
					case 6 : System.out.println("Enter the node data whose position u wanna get");
						 int nodData=ss.nextInt();
						 int pos1=getPos(nodData);	
						 System.out.println("***********Position of given node = "+pos1);
						 break;
					case 7 : printLinkedList();
						 break;
					case 8 : System.out.println("Enter the nth position from end that you want to search");
						 int n=ss.nextInt();
						 int n1=getNode(n);	
						 System.out.println("***********Element data at given position = "+n1);
						 break;
					case 9 : sortEvenOdd();	
						 printLinkedList();
						 break;
					case 10 :printLinkedList();
						 reverse();	
						 printLinkedList();
						 break;
					case 11 :printLinkedList();
						 System.out.println("Enter the number by which you wanna to rotate");
						 int by=ss.nextInt();
						 rotate(by);	
						 printLinkedList();
						 break;
					case 0 : System.exit(0);
				}
				
			}		
	}

}


