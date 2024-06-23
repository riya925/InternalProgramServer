import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket server=new ServerSocket(1234);
			
			System.out.println("\n Server is waiting.... ");
			Socket client=server.accept();

			DataInputStream dis=new DataInputStream(client.getInputStream());
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			String msg="";
			int c=0;
			
			msg=dis.readUTF();
			for(int i=0;i<msg.length();i++)
			{
				if(msg.charAt(i)=='a' || msg.charAt(i)=='e' || msg.charAt(i)=='i' || msg.charAt(i)=='o' || msg.charAt(i)=='u' || 
						msg.charAt(i)=='A' || msg.charAt(i)=='E' || msg.charAt(i)=='I' || msg.charAt(i)=='O' || msg.charAt(i)=='U')
				{
					c++;
				}
			}
			
			dos.writeInt(c);
			
			dis.close();
			dos.close();
			client.close();
			server.close();
		}
		catch(Exception e)
		{
			System.out.println("\n Error : "+e.getMessage());
		}
	}
}