import java.lang.*;
import java.io.*;
import java.net.*;

class Client
{
public static void main(String args[])
{
	try
	{	String Actual=new String();int i;char d[]=new char[50];
		Socket skt = new Socket("192.168.72.72", 1234);
		BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
		
		System.out.print("Received string: ");
		while (!in.ready()) {}
		

		Actual=Actual+in.readLine();
		System.out.println(Actual+"\n");
		

		for(i=0;i<Actual.length();i++)
		{	d[i]=Actual.charAt(i);
			if(d[i]<='e')
				d[i]+=21;
			else
			d[i]-=5;
			System.out.print(d[i]);
		}


		System.out.print("\n");
		in.close();
	}
	catch(Exception e)
	{	System.out.print("Whoops! It didn't work!\n");	}
}
}