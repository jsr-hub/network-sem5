import java.io.*;
import java.net.*;
import java.util.*;
public class SRClient
{
public static void main(String args[])
{
try
{
while(true)
{
Socket s=new Socket("localhost",5555);
System.out.println("socket created");
BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
String st=br.readLine();
System.out.println("the frames are:"+st);
System.out.println("\nenter the frame where there is an error:");
s.close();
s=new Socket("localhost",5555);
Scanner scanner=new Scanner(System.in);
String error=scanner.nextLine();
DataOutputStream out=new DataOutputStream(s.getOutputStream());
out.writeBytes(error);
System.out.println("sent");
s.close();
Thread.sleep(100);
}
}catch(Exception e)
{}
}
}