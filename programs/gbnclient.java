import java.io.*;
import java.net.*;
import java.util.*;
public class gbnclient
{
public static void main(String args[]) throws Exception 
{
try
{
while(true)
{
	Socket s=new Socket("localhost",5555);
	System.out.println("socket created");
	BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
	System.out.println("make duplicate to retransmit");
	String st=br.readLine();
	System.out.println("The frames are: "+st);
	System.out.println("Enter the first damaged frame: ");
	s.close();

	s=new Socket("localhost",5555);
	Scanner scanner=new Scanner(System.in);
	String error=scanner.nextLine();
	DataOutputStream out=new DataOutputStream(s.getOutputStream());
	out.writeBytes(error);
	System.out.println("sent");
	s.close();
	Thread.sleep(100);
}}
catch(Exception e)
{}
}
}
