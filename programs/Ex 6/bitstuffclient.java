import java.util.*;
import java.io.*;
import java.net.*;
class bitstuffclient
{
	public static void main(String args[])
	{
		try
		{
			String st;
			Socket so=new Socket("localhost",2000);
			DataInputStream d=new DataInputStream(so.getInputStream());
			int c=0;
			int n=d.readInt();
			st=Integer.toBinaryString(n);
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
					st=st.substring(0,i+1)+st.substring(i+2);
				}
			}
			n=Integer.parseInt(st,2);
			System.out.println(st+"\n"+n);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}