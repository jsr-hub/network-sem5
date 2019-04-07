/*import java.io.*;
import java.net.*;
public class srcli
{public static void main(String args[])throws Exception
 {int j,c=0;
  Socket s=new Socket("127.0.0.1",4000);
   BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
   for(j=0;j<15;j++)
   {
     System.out.println(br.read());
   }
   System.out.println("\nrepeated msg is\n");
   System.out.println(br.read());
  }
}*/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;
public class srcli extends Frame implements ActionListener
{TextArea ta;
  Button  b;
  Socket soc;
   BufferedReader br;
Byte by[];
  public srcli()
  {try
    { setLayout(null);
      setBackground(Color.green);
      ta=new TextArea(100,100);
      ta.setBounds(100,100,140,150);
      add(ta);
      b=new Button("receive");
      b.setBounds(250,250,40,40);
      add(b);
      b.addActionListener(this);
      soc=new Socket("127.0.0.1",4000);
      by=new Byte[27];
      br=new BufferedReader(new InputStreamReader(soc.getInputStream()));
    }
    catch(Exception e){}
  }
  public void actionPerformed(ActionEvent e)
  {String s=e.getActionCommand();
    int are;char chs;
   String d="";
   if(s.equals("receive"))
   {try{
     for(int j=0;j<15;j++)
     {are=br.read();
      chs=(char)are;
      d=d+chs;
      ta.setText(d);
    }
    System.out.println("\nrepeated msg is\n");
    System.out.println(br.read()); 
    }//end try
    catch(Exception ae){}
   }//end if
 }//end action
 public static void main(String args[])
 {srcli sr=new srcli();
   sr.setVisible(true);
   sr.setSize(500,300);
 }//end main
}//end class