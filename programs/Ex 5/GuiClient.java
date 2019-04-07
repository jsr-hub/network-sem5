import java.io.*;
import java.net.*;
import java.awt.event.*;
import java.awt.*;
class myframe extends Frame implements ActionListener
{
	TextArea ta;
	TextField tf;
	Button b;
	Panel p1,p2;
	Socket s;
	DataInputStream d;
	OutputStream o;
myframe(Socket sk)
{
	super("chat");
	setLayout(new FlowLayout());
	try
	{
	s=sk;
	d=new DataInputStream(s.getInputStream());
	o=s.getOutputStream();
	ta=new TextArea(30,30);
	tf=new TextField(20);
	b=new Button(">>");
	b.addActionListener(this);
	addWindowListener(new WindowAdapter()
	{
		public void windowClosing(WindowEvent w)
		{
			System.exit(1);
		}
	});
	add(ta);
	add(tf);
	add(b);
	}
	catch(Exception e)
	{
				System.out.println(e);

	}
}
public void actionPerformed(ActionEvent a)
{
try
	{
		
		String s=tf.getText();
	while(s=="")
	{
	s=tf.getText();	
	}
		tf.setText("");
	ta.append("You: "+s+"\n");
	s=s+"\n";
	o.write(s.getBytes());
		Thread.sleep(10);
	String msg=d.readLine();
	ta.append("Friend: "+msg+"\n");
	if(msg=="Bye")
	System.exit(0);
		
}
	catch(Exception e)
	{
				System.out.println(e);

	}
}
}
class GuiClient
{
public static void main(String args[])
{
	try
	{
		Socket s=new Socket("localhost",3000);
		System.out.println("Test");
		myframe m=new myframe(s);
		m.setVisible(true);
		m.setSize(500,500);
	}
	catch(Exception e)
	{
				System.out.println(e);

	}
}
}