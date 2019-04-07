import java.net.*;
import java.io.*;
class ClientSide
{
public static void main(String args[]) throws Exception
{
Socket s=new Socket("localhost",1234);
InputStreamReader isr=new InputStreamReader(s.getInputStream());
int count=0;
BufferedReader br=new BufferedReader(isr);
String dubit=br.readLine();String dubit1="";
String dubyte=br.readLine();String dubyte1="";
System.out.println("Bit Stuffed data is:"+dubit);
System.out.println("Byte Stuffed data is:"+dubyte);
for(int i=0;i<dubit.length();i++)
{	dubit1+=dubit.charAt(i);
	if(dubit.charAt(i)=='1')
	{
		count++;
		if(count==5)
		{
			count=0;
			i++;
		}
	}
	else
		count=0;
}
for(int i=0;i<dubyte.length();i++)
{	
	if(dubyte.charAt(i)=='s')
	{
		if(dubyte.charAt(i+1)=='\\')
			i++;
	}
	else if(dubyte.charAt(i)=='\\')
	{	
		if(dubyte.charAt(i+1)=='\\')
		{
			i++;
		}
	}
	dubyte1+=dubyte.charAt(i);
}	
System.out.println("Bit Un-Stuffed data is:"+dubit1);
System.out.println("Byte Un-Stuffed data is:"+dubyte1);		
isr.close();
s.close();
}
}