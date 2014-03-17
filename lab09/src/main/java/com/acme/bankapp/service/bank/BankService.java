package com.acme.bankapp.service.bank;

import com.acme.bankapp.domain.bank.Bank;
import com.acme.bankapp.domain.bank.Client;

public class BankService {

	public static void addClient( Bank bank, Client client) 
	{
		bank.getClients().put(client.getClientId(), client );
	}
	
}
