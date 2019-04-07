import java.io.*;
public class Ex6B_Hamm
{
	
	public static void main(String str[])throws IOException
	{
		System.out.println("\nHamming code Error Detection and Correction...TR");
		
		int data[]=new int[15];
		int sndData[]=new int[15];
		int rcvData[]=new int[15];
		
		int r1,r2,r4,r8;
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("\nEnter the BIT one by one...:");
		
		for(int i=1;i<8;i++)
		{
			data[i]=Integer.parseInt(br.readLine());		
		}
		
		
		//Assign data to snd data TR
		sndData[3]=data[7];
		sndData[5]=data[6];
		sndData[6]=data[5];
		sndData[7]=data[4];
		sndData[9]=data[3];
		sndData[10]=data[2];
		sndData[11]=data[1];
		
		
		sndData[1]=sndData[2]=sndData[4]=sndData[8]=0;
		r1=r2=r4=r8=0;
		
		//Rn calculation TR  r1=1,3,5,7,9,11, r2=2,3,6,7,10,11, r4=4,5,6,7, r8=8,9,10,11
		r1=sndData[1]+sndData[3]+sndData[5]+sndData[7]+sndData[9]+sndData[11];
		r2=sndData[2]+sndData[3]+sndData[6]+sndData[7]+sndData[10]+sndData[11];
		r4=sndData[4]+sndData[5]+sndData[6]+sndData[7];
		r8=sndData[8]+sndData[9]+sndData[10]+sndData[11];
		
		
		//Check even parity if even rn=0 or rn=1  TR
		r1%=2;
		r2%=2;
		r4%=2;
		r8%=2;
		System.out.println("R bit 			:"+ r1 + " "+ r2 +" "+ r4+" "+r8);
		
		
		sndData[1]=r1;
		sndData[2]=r2;
		sndData[4]=r4;
		sndData[8]=r8;
		
		System.out.println("Given Data    	:");
		for(int i=1;i<8;i++)
		{
			System.out.print(data[i]);		
		}
		
		//Display TR bits
		System.out.println("Formatted Data	:");
		for(int i=11;i>0;i--)
		{
			System.out.print(sndData[i]+" ");		
		}
		////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\nEnter the 11 bit number one by one...with or woth out single bit error...");
		for(int i=1;i<12;i++)
		{
			rcvData[12-i]=Integer.parseInt(br.readLine());		
		}
		
		
		r1=r2=r4=r8=0;
		
		//Rn calculation TR  r1=1,3,5,7,9,11, r2=2,3,6,7,10,11, r4=4,5,6,7, r8=8,9,10,11
		r1=rcvData[1]+rcvData[3]+rcvData[5]+rcvData[7]+rcvData[9]+rcvData[11];
		r2=rcvData[2]+rcvData[3]+rcvData[6]+rcvData[7]+rcvData[10]+rcvData[11];
		r4=rcvData[4]+rcvData[5]+rcvData[6]+rcvData[7];
		r8=rcvData[8]+rcvData[9]+rcvData[10]+rcvData[11];
		
		
		//Check even parity if even rn=0 or rn=1  TR
		r1%=2;
		r2%=2;
		r4%=2;
		r8%=2;
		
		
		System.out.println("Error bit 		:"+ r8 + " "+ r4 +" "+ r2+" "+r1);
		
		
		int errBit=0;
		errBit=r8*8+r4*4+r2*2+r1*1;
		
		System.out.println("Error bit 		:"+ errBit);
		System.out.println("Data after error correction...	:");
		
		if(rcvData[errBit]==1)
			rcvData[errBit]=0;
		else
			rcvData[errBit]=1;
		
		for(int i=11;i>0;i--)
		{
			System.out.print(rcvData[i]+" ");		
		}
		
		
		
	}
	
}