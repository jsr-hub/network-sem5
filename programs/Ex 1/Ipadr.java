import java.util.*;
import java.lang.*;
import java.net.*;
public class Ipadr 
{
public static void main(String args[])
{
try
{
byte b[]=new byte[]{(byte)192,(byte)168,(byte)10,(byte)11};
InetAddress InetA=InetAddress.getByAddress(b);
System.out.println("Start of pgm...\n");
boolean con=InetA.isReachable(10000);
String addr=new String();
addr=InetA.getHostAddress();
String name=new String();
name=InetA.getHostName();
System.out.println("Connection was a success");
System.out.println("Name:"+name+"\nAddress:"+addr+"  "+con);
}
catch(Exception e)
{	System.out.println("There was some error");}
}
}