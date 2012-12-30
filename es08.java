/*
Scrivere in C o Java un programma che:

    apra una connessione verso l'IP 151.97.252.130, port 80
    invii la stringa "GET /pappalardo/prova/08.aux\n"
    nello stream testo ricevuto, salti le prime 22015 righe e scriva sulla standard output le righe dalla 22016 alla 22023
    salti altre 3828 righe in avanti
    legga il numero intero all'inizio della nuova riga corrente: si tratta di un ulteriore numero di riga, che diremo n
    scriva le righe dalla n alla n+8

*/

import java.io.*;
import java.net.*;

public class es08
{
	public static void main(String[] args)
	{
		String tmp, msg;
		int i, n;
		try
		{
			InetAddress address = InetAddress.getByName("151.97.252.130");
			Socket client = new Socket(address, 80);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())),true);
			
			out.println("GET /pappalardo/prova/08.aux\n");
			
			msg = "";
			i = 1;
			while ((tmp = in.readLine()) != null)
			{
				if (i > 22015 && i < 22024)
					msg += tmp;
				i++;
			}
			
			for (int x = 0; x < 3828; i ++)
				in.readLine();
				
			tmp = in.readLine();
			System.out.println(tmp.charAt(0));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
