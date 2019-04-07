import java.util.*;
import java.io.*;
class routing
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n,i,j,k,src;
		int[][] a=new int [10][10];
		System.out.println("Enter the number of nodes");
		n=in.nextInt();

		for(i=1;i<=n;i++)
		for(j=1;j<=n;j++)
			a[i][j]=9999;

		int ch=1;
	System.out.println("Enter Node -> Node and distance..");
	i=1;
	int sr,de;
	while(ch!=0)
	{
		System.out.print("Enter the Src node:");
		sr=in.nextInt();
			
		System.out.print("Enter the Des node:");
		de=in.nextInt();

		System.out.println("Enter the distance between"+sr+"and"+de);
			a[sr][de]=in.nextInt();
			a[de][sr]=a[sr][de];

		System.out.print("Do you want to continue...1.Continue..0.Exit..:");
		ch=in.nextInt();
	}
	//Display
	for(i=1;i<=n;i++)
	for(j=1;j<=n;j++)
	if(a[i][j]!=9999)
		System.out.println(i + "=>" + j + ":"+a[i][j]);
	
		for(i=1;i<=n;i++){a[i][i]=0;}
		
		
		for(i=1;i<=n;i++)
		     for(j=1;j<=n;j++)
		for(k=1;k<=n;k++)
		if(a[i][j]>a[i][k]+a[k][j])
			a[i][j]=a[i][k]+a[k][j];
		

		System.out.println("Enter the Target Node:");
		src=in.nextInt();
			for(k=1;k<=n;k++)
			{
				if(k!=src)
				{
					if(a[src][k]!=9999)
					{
						System.out.println("The shortest distance between"+src+"and"+k+"is"+a[src][k]); 
					}
					else
						System.out.println("There is no path between the source and destination");
				}
			}
	
	
		}
	}