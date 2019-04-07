import java.util.*;
import java.io.*;
import java.net.*;

class bitstuff
{
	public static void main(String args[])
	{
		try
		{
			String st;
			ServerSocket ss=new ServerSocket(2000);
			Socket so=ss.accept();
			DataOutputStream out=new DataOutputStream(so.getOutputStream());
			Scanner s=new Scanner(System.in);
			System.out.println("Enter a number");
			int n=s.nextInt();
			st=Integer.toBinaryString((int)n);
			int c=0;
			System.out.println(st+"\n");
			for(int i=0;i<st.length();i++)
			{
				if(st.charAt(i)=='1')
				{
					c++;
				}
				if(c==5)
				{
					c=0;
					st=st.substring(0,i+1)+'0'+st.substring(i+1);
				}
			}
			n=Integer.parseInt(st,2);
			out.writeInt(n);
			System.out.println(st+"\n");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}