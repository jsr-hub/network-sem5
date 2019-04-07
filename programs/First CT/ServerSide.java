import java.util.*;
import java.net.*;
import java.io.*;
class ServerSide
{
public static void main(String args[]) throws Exception
{
ServerSocket ss=new ServerSocket(1234);
Socket s1=ss.accept();
PrintWriter out=new PrintWriter(s1.getOutputStream(),true);
Scanner s=new Scanner(System.in);
String data="",databit="",databyte="";
System.out.println("Enter the data:");
data=s.next();
int count=0;
for(int i=0;i<data.length();i++)
	if(data.charAt(i)=='1')
	{
		count++;
		databit=databit+"1";
		if(count==5)
		{
			databit=databit+"0";
			count=0;
		}
	}
	else
	{
		databit=databit+data.charAt(i);
		count=0;
	}
System.out.println("Bit Stuffed data is:"+databit);
for(int i=0;i<data.length();i++)
	if(data.charAt(i)=='\\')
    {   if(data.charAt(i+1)=='\\')
		{
			databyte=databyte+"\\\\\\";
			i++;
		}
		else
			databyte=databyte+"s\\";
    }
	else
		databyte=databyte+data.charAt(i);
System.out.println("Byte Stuffed data is:"+databyte);
out.print(databit);
out.print("\n");
out.print(databyte);
out.close();
ss.close();
}
}

			