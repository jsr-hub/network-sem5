import java.io.*;
import java.net.*;
public class SRServer
{
static int burst=5;
public static void main(String args[])
{
try
{
int x=0,i;
String error=" ";
while(true && x<20)
{
String data=error;
error=" ";
int len=data.length();
for(i=0;i<burst;i++,x++)
data+=(char)('A'+x);
System.out.println("the new set to be sent is:"+data);
ServerSocket ss=new ServerSocket(5555);
Socket s=ss.accept();
DataOutputStream out=new DataOutputStream(s.getOutputStream());
out.writeBytes(data);
System.out.println("sent");
s.close();
ss.close();
Thread.sleep(100);
ss=new ServerSocket(5555);
s=ss.accept();
BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
System.out.println("waiting....");
error=br.readLine();
System.out.println("the error is at:"+error);
s.close();
ss.close();
}
}catch(Exception e)
{}
}
}