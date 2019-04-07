import java.util.*;
import java.io.*;
import java.net.*;
class bytestuffclient
{
	public static void main(String args[])
	{
		try
		{
			String st;
			Socket so=new Socket("localhost",2000);
			DataInputStream d=new DataInputStream(so.getInputStream());
			int c=0;
			st=d.readLine();
			for(int i=0;i<st.length();)
			{
				if(st.charAt(i)=='s')
				{
					st=st.substring(0,i-1)+"/"+st.substring(i);
								System.out.println(st+"\n");
							i+=2;


				}
					else
					i++;
			}
			for(int i=0;i<st.length()-1;)
			{
				if(st.charAt(i)=='/'&&st.charAt(i+1)=='/')
				{
					st=st.substring(0,i-1)+"/"+st.substring(i);
								System.out.println(st+"\n");
								i+=3;
								

				}
				else
					i++;
			}
			System.out.println(st+"\n"+n);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}