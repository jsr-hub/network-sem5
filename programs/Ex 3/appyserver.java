import java.lang.*;
import java.io.*;
import java.net.*;

public class appyserver {
   public static void main(String args[]) throws Exception{
      try
{    String data,dat=""; int i; char d[]= new char[50]; 
      ServerSocket srvr = new ServerSocket(1234);
         Socket skt = srvr.accept();
         System.out.print("Server has connected!\n");
        System.out.println("Enter something: ");
      InputStreamReader isr= new InputStreamReader(System.in);
      BufferedReader bf= new BufferedReader(isr);
      data =bf.readLine();
         for(i=0;i<data.length();i++)
         {  d[i]=data.charAt(i);
             if(d[i]>='v')
               {d[i]-=97; 
                 d[i]+=76; }
             else
              d[i]+=5;
             dat+= d[i];
         }
         PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
         System.out.print("Sending string: '" + data + "'\n");
         out.print(dat);
         out.close();
         skt.close();
         srvr.close();
      }
      catch(Exception e) {
         System.out.print("Whoops! It didn't work!\n"+e);
      }
   }
}