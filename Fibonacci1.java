import java.util.Scanner; 

public class Fibonacci1
{
	public static void main(String args[])
	{
		System.out.println(" Enter the Length of Fibonacci ?? ");
		Scanner sc=new Scanner(System.in);
		int len=sc.nextInt();

		int n1=1;
		int n2=1;
		System.out.print(n1+" "+n2);
		
		for(int i=3;i<=len;i++)
		{
			int n3=n1+n2;
			System.out.print(" "+n3);
			n1=n2;
			n2=n3;		
		}
		System.out.println();

	}
		
	
}

