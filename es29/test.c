
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <string.h>

#define DIM 100
#define SERVERPORT 33333
#define SERVERADDRESS "127.0.0.1"
#define MAXBUF 32

// memorizza il numero di stringhe attualmente memorizzate nel server
int count;

// resetta le stringhe
void reset(char **strings)
{
	int i;
	for (i = 0; i < count; i++)
		strings[i] = "";
	count = 0;
	return;
}

// memorizza una nuova stringa
void insert(char **strings, char *new)
{
	strings[count] = new;
	count++;
}

int main()
{
	int i;
	char *strings[DIM], *buffer, client_address;
	int server_socket, connect_socket, retcode;
	struct sockaddr_in server_addr, client_addr;
	socklen_t client_addr_len;
	
	count = 0;
	
	insert(strings, "asd");
	insert(strings, "prova");
	insert(strings, "test");
	insert(strings, "ciao");
	
		// debug
		for (i = 0; i < count; i++)
			printf("%s\n",strings[i]);
			
	return 0;
}
