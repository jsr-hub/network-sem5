 import java.io.*;
import java.net.*;
public class gbacknserver{
static int burst=5;
public static void main(String args[]) throws Exception
{
try
{
int i, error=0;
//String err=" ";
while(true)
{
int x=error;
String data=" ";
int len=data.length();
for(i=0;i<burst;i++,x++)
data+=(char)('A'+x);
System.out.println("\n The new window to be sent is:"+data);
ServerSocket ss=new ServerSocket(5555);
Socket s=ss.accept();
DataOutputStream out= new DataOutputStream(s.getOutputStream());
out.writeBytes(data);
System.out.println("\n sent");
s.close();
ss.close();
Thread.sleep(100);
ss=new ServerSocket(5555);
s=ss.accept();
BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
System.out.println("\nwaiting");
error=Integer.parseInt(br.readLine());
System.out.println("\nError is at: "+error);
s.close();
ss.close();
}
}
catch(Exception e)
{}
}
}