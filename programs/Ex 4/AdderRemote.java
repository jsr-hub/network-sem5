import java.rmi.*;
import java.rmi.server.*;

public class AdderRemote extends UnicastRemoteObject implements Adder{

AdderRemote()throws RemoteException{
super();
}

public int add(int x,int y)
{
int i,j=1;
for(i=0;i<y;i++)
j*=x;
return j;
}
}
