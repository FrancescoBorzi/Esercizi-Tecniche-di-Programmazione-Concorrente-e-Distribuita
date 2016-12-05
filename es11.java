/*
Scrivere in C o Java un programma che:

    apra una connessione verso l'host www.dmi.unict.it, port 80
    invii la stringa "GET /pappalardo/prova/11.aux\n"
    nello stream di byte ricevuti individui la prima parentesi quadra aperta
    memorizzi tutti i successivi byte fino alla prima parentesi quadra chiusa, che il server invierà, in una variabile stringa denominata "s"
    invii, sulla connessione già aperta, la stringa s (attenzione: dovrebbe terminare per "\n")
    scriva i byte ricevuti in risposta sulla standard output
*/

import java.io.*;
import java.net.*;

public class es11
{
	public static String finder(String inc)
	{	
		int x;
		for (int i = 0; i < inc.length(); i++)
		{
			if(inc.charAt(i) == '[')
			{
				x = i+1;
				while (inc.charAt(x) != ']')
					x++;
				return(inc.substring(i+1, x));
			}
		}
		return null;
	}
	
	public static void main(String args[])
	{
		try
		{
			InetAddress indirizzo = InetAddress.getByName("www.dmi.unict.it");
			Socket client = new Socket(indirizzo, 80);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			
			out.println("GET /pappalardo/prova/11.aux\n");
			
			String tmp = "";
			
			int num = 0;
			
			while ((tmp += in.readLine()) != null)
				System.out.println(num++);
			
			tmp = finder(tmp);
			
			in.close();
			out.close();
			client.close();
			
			client = new Socket(indirizzo, 80);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
			
			System.out.println(tmp);
			
			out.println(tmp);
			
			tmp = "";
			
			while ((tmp += in.readLine()) != null);
			
			System.out.println(tmp);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
