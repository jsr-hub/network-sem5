import java.util.*;
import java.net.*;
import java.io.*;
import java.lang.*;
class ServerSide
{
public static void main(String args[]) throws Exception
{
ServerSocket ss=new ServerSocket(1234);
Socket s1=ss.accept();
PrintWriter out=new PrintWriter(s1.getOutputStream(),true);
Scanner s=new Scanner(System.in);
String data[]=new String[10];
String dat="";
for(int i=0;i<10;i++)
    data[i]=java.lang.String.valueOf(i);
for(int i=0;i<10;i++)
{
    out.print(data[i]);
    out.print("\n");
}
int k=0,flag=0;
Socket sw=new Socket("localhost",1234);
InputStreamReader isr=new InputStreamReader(sw.getInputStream());
BufferedReader br=new BufferedReader(isr);
String sl=br.readLine();
if(sl.equals("Received"))
    flag=1;
if(flag!=1)
    k=Integer.parseInt(sl);
for(int i=k;i<10;i++)
{
    out.print(data[i]);
    out.print("\n");
}
out.close();
ss.close();
}
}

			