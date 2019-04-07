import java.net.*;
import java.io.*;
import java.util.*;
class ClientSides
{
void ack()
{
    try
    {
ServerSocket ss=new ServerSocket(1234);
Socket s1=ss.accept();
PrintWriter out=new PrintWriter(s1.getOutputStream(),true);
out.print("RECEIVED");
out.close();
s1.close();
ss.close();
    }
    catch(Exception e)
    {}
}
public int reqresend(String a[])
{int res=0;try
    {
int datai[]=new int[10];
ServerSocket ss=new ServerSocket(1234);
Socket s1=ss.accept();
PrintWriter out=new PrintWriter(s1.getOutputStream(),true);
for(int i=0;i<10;i++)
    datai[i]=Integer.parseInt(a[i]);
for(int i=0;i<10;i++)
    if((datai[i]+1)!=datai[i])
    {
        res=i;
        break;
    }    
out.print(res);
out.close();
s1.close();
ss.close();

    }
    catch(Exception e){}
    return res;
}  
}
public class ClientSide
{    
public static void main(String args[]) throws Exception
{Scanner str=new Scanner(System.in);
//System.out.println("Enter pkt to damage");
//int j=str.nextInt();
ClientSides c=new ClientSides();
Socket s=new Socket("localhost",1234);
InputStreamReader isr=new InputStreamReader(s.getInputStream());
BufferedReader br=new BufferedReader(isr);
String duta[]=new String[10];int length=0;
for(int i=0;i<10;i++)
{   duta[i]=br.readLine();
    System.out.println(duta[i]);
   /* if(i!=j)
    {
            length++;
    }*/
}
/*for(int i=0;i<10;i++)
{
    if(i==j)
    {
        for(int l=i;l<10;l++)
        {
            duta[i]=duta[i+1];
        }    
        break;
    }
} */   
if(length<10)
{   int k=c.reqresend(duta);
    for(int i=k;i<10;i++)
        duta[i]=br.readLine();
}
else
    c.ack();
for(int i=0;i<10;i++)
System.out.println("The data is:"+duta[i]);
isr.close();
s.close();
}
}