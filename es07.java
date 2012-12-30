/*
Scrivere in C o Java un programma che:

1)    apra una connessione verso l'IP 151.97.252.130, port 80
2)    invii la stringa "GET /pappalardo/prova/07.aux\n"
3)    nello stream di byte ricevuti, cerchi il primo contenente il carattere '-'
4)    memorizzi quindi i successivi 31 byte
5)    scriva questi 31 byte sulla standard output
*/

import java.io.*;
import java.net.*;

public class es07
{
	public static void main(String[] args)
	{
		String tmp, msg;
		int i;
		try
		{
			InetAddress address = InetAddress.getByName("151.97.252.130");
			Socket client = new Socket(address, 80);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())),true);
			
			out.println("GET /pappalardo/prova/07.aux");
			
			msg = "";
			
			while ((tmp = in.readLine()) != null)
				msg += tmp;
				
			i = 0;
			while(msg.charAt(i) != '-')
				i++;
			
			// java.lang.StringIndexOutOfBoundsException perchè ci sono troppe xxx e un int non basta
			msg = msg.substring(i, 16);
			
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
