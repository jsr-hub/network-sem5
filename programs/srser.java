/*
import java.io.*;
import java.net.*;
public class srser
{public static void main(String args[])throws Exception
 {int windowsize=15,i;
   ServerSocket ss=new ServerSocket(4000);
   Socket s=ss.accept();
   String str="abcdefghijklmno";
   char ch[]=str.toCharArray();
   BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
   DataOutputStream ds=new DataOutputStream(s.getOutputStream());
   for(i=0;i<windowsize;i++)
       {if(i!=8)ds.write(ch[i]);Thread.sleep(10);}
   System.out.println("msg sent");
   System.out.println("msg resending");
   //for(i=8;i<windowsize;i++)
   {ds.write(ch[8]);Thread.sleep(10);}
 }
}
*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;
public class srser extends Frame implements ActionListener
{TextField tf;
  TextArea msg;
  Button b;
  Label l;
  ServerSocket ss;
  Socket soc;
  BufferedReader br;
  DataOutputStream ds;
  public srser()
  {
   try
  { setLayout(null);
    setBackground(Color.cyan);
    msg=new TextArea();
    msg.setBounds(250,100,200,100);
    b=new Button("send");
    b.setBounds(350,200,100,50);
    add(msg);
    add(b);
     b.addActionListener(this);
     tf=new TextField();
     tf.setBounds(200,100,40,20);
     add(tf);
      ss=new ServerSocket(4000);
     soc=ss.accept();
    }catch(Exception e)
	{System.out.println(e);}
 }//srser
   public void actionPerformed(ActionEvent e)
   {
    String s=e.getActionCommand();
    if(s.equals("send"))
    {char ch[]=msg.getText().toCharArray();
      int i;
     try
     {
     br=new BufferedReader(new InputStreamReader(soc.getInputStream()));
     ds=new DataOutputStream(soc.getOutputStream());
     String d;
      for(i=0;i<ch.length;i++)
         {if(i!=Integer.parseInt(tf.getText()))
	{
	  d=new String(""+ch[i]);
                 ds.write(d.getBytes());
               }
              Thread.sleep(10);
         }
    System.out.println("msg sent");
    System.out.println("msg resending");
   ds.write(ch[Integer.parseInt(tf.getText())]);
    Thread.sleep(10);
    }//end try
    catch(Exception exp){}
    }//end if
  }//end action performed
  public static void main(String args[])
  {srser ser=new srser();
   ser.setVisible(true);
   ser.setSize(500,300);
  }
}//end class