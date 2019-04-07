import java.util.*;
import java.io.*;
import java.net.*;

class bytestuff
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
			System.out.println("Enter a string");
			st=s.next();
			for(int i=0;i<st.length();)
			{
				if(st.charAt(i)=='s')
				{
					st=st.substring(0,i)+"/"+st.substring(i);
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
					st=st.substring(0,i)+"/"+st.substring(i);
								System.out.println(st+"\n");
								i+=3;
								

				}
				else
					i++;
			}
		out.write(st.getByte());
			System.out.println(st+"\n");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}