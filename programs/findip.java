import java.io.*;
import java.net.*;
import java.util.*;
public class findip
{
 
 public static void main(String args[])
 {
	String str=" ";
   try
   {
   Scanner s=new Scanner(System.in);
   System.out.print("Enter the host name");
   str=s.next();
   InetAddress inet=InetAddress.getByName(str);
   System.out.print("The host name"+inet.getHostName());
   System.out.print("The IP address"+inet.getHostAddress());
   System.out.print("The IP of local host"+inet.getLocalHost());
   }
   catch(Exception e)
   {
   System.out.print(e);
   }
 }
}
