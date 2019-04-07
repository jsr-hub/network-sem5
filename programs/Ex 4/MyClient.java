import java.rmi.*;
import java.util.Scanner;

public class MyClient{

public static void main(String args[]){
try{
Scanner s=new Scanner(System.in);int x,y;
Adder stub=(Adder)Naming.lookup("rmi://localhost:5000/krishna");
System.out.println("Enter first number:");
x=s.nextInt();
System.out.println("Enter second number:");
y=s.nextInt();
System.out.println(stub.add(x,y));

}catch(Exception e){System.out.println(e);}
}

}
