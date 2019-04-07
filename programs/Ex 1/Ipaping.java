import java.util.*;
import java.lang.*;
import java.net.*;
import java.io.*;
public class Ipaping 
{
public static void main(String args[])
{
try
{
	String pingCmd="ping 192.168.72.3";
	Runtime Run=Runtime.getRuntime();
	Process p=Run.exec(pingCmd);
	InputStream ip=p.getInputStream();
	InputStreamReader isr=new InputStreamReader(ip);
	BufferedReader br=new BufferedReader(isr);
	String s;
	while((s=br.readLine())!=null)
	System.out.println(s);
}	
catch(Exception e)
{	System.out.println("No bruh");	}
}
}