import java.io.*;
import java.util.*;
import java.net.*;
public class ping
{
 public static void main(String args[])
 {
  try
  {
   String str="";
   Scanner s=new Scanner(System.in);
   System.out.print("Enter the ip address");
   str=s.nextLine();
   String pingCmd="ping"+str;
   Runtime r=Runtime.getRuntime();
   Process p=r.exec(pingCmd);
   Scanner s1=new Scanner(p.getInputStream());
   String inputLine;
   while(s1.hasNextLine())
   {
    inputLine=s1.nextLine();
	System.out.print(""+inputLine);
   }
  }
   catch(Exception e)
   {
    System.out.print(e);
   }
  }
 }