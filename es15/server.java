import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class server implements es15
{
	public int validate(String s)
	{
		if (s.length() != 9 || !isInt(s) || containsZero(s))
			return 0;
		
		boolean values[] = new boolean[9];
		int x;
		
		for (int i = 0; i < 9; i++)
		{
			x = Integer.parseInt(s.charAt(i)+"")-1;
			
			if (values[x] == true)
				return 0;
				
			values[x] = true;
		}
		
		return 1;
	}
	
	public boolean isInt(String str)
	{
		try
		{
			Integer.parseInt(str);
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		
		return true;
	}
	
	public boolean containsZero(String str)
	{
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) == '0')
				return true;
		return false;
	}
	
	public static void main(String args[])
	{
		try
		{
			server obj = new server();
			
			// TODO: FIX SOMETHING HERE!!!
			es15 stub = (es15) UnicastRemoteObject.exportObject(obj, 0);
			
			Registry reg = LocateRegistry.getRegistry("localhost");
			reg.bind("es15", stub);
			
			System.out.println("Server running.. (CTRL-C quits)");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
