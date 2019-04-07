import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEventListener;
import gnu.io.PortInUseException;
import gnu.io.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.lang.*;
public class RS232Example extends Frame implements ActionListener, SerialPortEventListener
{
  	   TextField tf; 
	   Button b;
	   public TextArea ta;
	   OutputStream out;
	   InputStream in;
	   byte[] buffer = new byte[2048];
	   int tail = 0;
	   public RS232Example(String Title) 
	   {
		   super(Title);
		   setLayout(new FlowLayout());
		   tf= new TextField(20);
		   b = new Button("Send");
		   ta = new TextArea(10, 35);
		   add(tf);
		   add(b);
		   add(ta);
		   b.addActionListener(this);
		   addWindowListener(new wa(this));
	   }
   	public void actionPerformed(ActionEvent ae) 
	{
		   String mes = tf.getText()+"\n";
		   send(mes.getBytes());
	}
	public void serialEvent(SerialPortEvent event)
	{
		   switch(event.getEventType()) 
		   {
			   case SerialPortEvent.BI:
			   case SerialPortEvent.OE:
			   case SerialPortEvent.FE:
			   case SerialPortEvent.PE:
			   case SerialPortEvent.CD:
			   case SerialPortEvent.CTS:
			   case SerialPortEvent.DSR:
			   case SerialPortEvent.RI:
			   case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			   break;
			   case SerialPortEvent.DATA_AVAILABLE:
			   byte b;
			   try 
			   {
				   while((b = (byte)in.read()) != -1) 
				   {
           				   	if (b=='\n') 
					                   onMessage(); 
						else 
						{
							   buffer[tail] = b;
					                   tail++;
					  	}
			     	   }
			     	   onMessage();
		   	    }
			    catch (IOException e)
			    {
				System.out.println("IO Exception");
			    }
		   }
   	}
 
   
	public void send(byte[] bytes) 
   	{
	       try 
	       {
		           ta.append("SENDING: " + new String(bytes, 0, bytes.length));
	                   out.write(bytes);
		           out.flush();
	        } 
	       catch (IOException e) 
	      {
	           e.printStackTrace();
	      }
   	}
	 public void connect(String portName) throws Exception 
	{
        		CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
	                  try 
			  { 
		            SerialPort serialPort = (SerialPort) portIdentifier.open("RS232Example", 5000);
      	            	    serialPort.addEventListener(this);
          		    serialPort.notifyOnDataAvailable(true);
	            	    serialPort.setSerialPortParams(38400, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                            out = serialPort.getOutputStream();
                            in = serialPort.getInputStream();
     	                  }
	           	  catch (Exception e)
                          { 
 		        	System.out.println(e);
				System.exit(0);
                          }
        }
        private void onMessage()
        {
	        if (tail!=0) 
	        {
		            String message = new String(buffer, 0, tail);
		            ta.appendText("RECEIVED : " + message+"\n");
		            if ("BYE".equals(message)) 
		           {
		           		send("ACK\n".getBytes());
	      	                        this.dispose();
                                        System.exit(0);
            		   }
	                   else if ("ACK".equals(message))
                           {                  {
			            	this.dispose();
			                System.exit(0);
		           }
		           tail = 0;
    	    }
    }
    
    public static void main(String[] args) throws Exception
    {
   	     RS232Example re = new RS232Example(args[0]);
	     re.setVisible(true);
	     re.setSize(300, 300);
	     re.connect(args[0]);
      
    }
}
class wa extends WindowAdapter
 {
	RS232Example r;
	public wa(RS232Example r)
	{
		this.r = r;
	}
	public void windowClosing(WindowEvent we)
	{
		r.setVisible(false);
		r.dispose();
		System.exit(0);
	}
}