package com.acme.bankapp;

import java.util.TreeMap;

public class Bank {
	
	private TreeMap<String, Client> clients;
	
	Bank() {
		
        System.out.println( "Bank started!" );
    	System.out.println();
        
    	clients = new TreeMap <String, Client> ();
    	
	}
	
	public TreeMap<String, Client> getClients() {
		return clients;
	}
	
	public void addClient( Client client) {
		clients.put(client.getClientId(), client );
	}
	
}
