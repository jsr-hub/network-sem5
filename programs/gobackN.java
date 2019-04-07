import java.io.*;
public class GoBackN {

 public static void main(String args[]) throws IOException
 {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  System.out.println("Please enter the Window Size: ");
  int window = Integer.parseInt(br.readLine());
  
  boolean loop = true;
  int sent = 0;
  
  while(loop)
  {
   
   for(int i = 0; i < window; i++)
   {
    System.out.println("Frame " + sent + " has been transmitted.");
    sent++;
    if(sent == window)
     break;
   }
   
   System.out.println("Please enter the last Acknowledgement received.");
   int ack = Integer.parseInt(br.readLine());
   
   if(ack == window)
    loop = false;
   else
    sent = ack;
  }
  
 }
 
}

output:-

Please enter the Window Size: 
7
Frame 0 has been transmitted.
Frame 1 has been transmitted.
Frame 2 has been transmitted.
Frame 3 has been transmitted.
Frame 4 has been transmitted.
Frame 5 has been transmitted.
Frame 6 has been transmitted.
Please enter the last Acknowledgement received.
3
Frame 3 has been transmitted.
Frame 4 has been transmitted.
Frame 5 has been transmitted.
Frame 6 has been transmitted.
Please enter the last Acknowledgement received.
5
Frame 5 has been transmitted.
Frame 6 has been transmitted.
Please enter the last Acknowledgement received.
7