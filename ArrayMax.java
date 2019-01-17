import java.util.Scanner;

public class ArrayMax
{
	public static void main(String args[])
	{
		System.out.println("Enter the size of the array");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter the elemetns");
		for(int i=0;i<n;i++)
		{
			int item=sc.nextInt();
			a[i]=item;
		}
		System.out.println("Inputed array..");
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println("Max element in the arry "+arrMax(a,n));
		
	}

	public static int arrMax(int[] a,int n)
	{
		int max=a[0];
		for(int i=1;i<n;i++)
		{
			if(max<a[i])
				max=a[i];
		}
		return max;
	}
}
