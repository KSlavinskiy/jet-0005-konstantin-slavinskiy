package com.acme.bankapp.service.bank;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.acme.bankapp.domain.bank.Bank;
import com.acme.bankapp.domain.bank.Client;
import com.acme.bankapp.util.ClientNotFoundCustException;
import com.acme.bankapp.util.MoneyFormatter;
import com.acme.bankapp.util.NoMoneyOnAccountCustException;
import com.acme.bankapp.util.OperationType;
import com.acme.bankapp.util.UnrecAccOpCustException;

public class BankService {

	public static void addClient( Bank bank, Client client) 
	{
		bank.getClients().put(client.getClientId(), client );
	}
	
    public static void printBalance( Bank bank ) {

    	Set< Map.Entry <String, Client> > tm = bank.getClients().entrySet();
    	for ( Map.Entry <String, Client> me : tm ) {
        	//System.out.println( "Client key: " + me.getKey() ); 
        	System.out.print( "Client id: " + me.getValue().getClientId() + " -- "); 
            System.out.println( me.getValue().getClientSalutation() );
        	System.out.print( "Client account #: " + me.getValue().getClientAccount().getAccount() + " -- " ); 
         	//printing the balance
        	System.out.println( "Account balance: " + 
        			new MoneyFormatter(me.getValue().getClientAccount().getBalance()).formattedMoney); 
        	System.out.println();

    	}
    	System.out.println();
    }
    
    
    public static void printMaximumAmountToWithdraw( Bank bank) {
    	
    	long money;
    	String balanceLine;
    	
    	Set< Map.Entry <String, Client> > tm = bank.getClients().entrySet();
    	for ( Map.Entry <String, Client> me : tm ) {
        	//System.out.println( "Client key: " + me.getKey() ); 
        	System.out.print( "Client id: " + me.getValue().getClientId() + " -- "); 
            System.out.println( me.getValue().getClientSalutation() );
        	System.out.print( "Client account #: " + me.getValue().getClientAccount().getAccount() + " -- " ); 
         	
        	//printing the balance
        	balanceLine = ( money = me.getValue().getClientAccount().maximumAmountToWithdraw()) > 0  ? 
        		"Money for withdrawal: " + new MoneyFormatter(money).formattedMoney                  : 
        		"No money on the account"         													 ;
        	System.out.println(balanceLine);
        	
        	System.out.println();

    	}
    	System.out.println();
    	
    }
    
    public static void modifyBank ( Bank bank, String clientId, long moneyAmount, OperationType operationType ) 
    throws UnrecAccOpCustException, ClientNotFoundCustException, NoMoneyOnAccountCustException  {
    	
    	TreeMap<String, Client> clients = bank.getClients();
    	Client cl = clients.get(clientId);
    	if( cl == null) 
			throw new ClientNotFoundCustException();
    	
//    	switch (operationType) {
//    	
//    		case Deposit:
//    			cl.getClientAccount().deposit(moneyAmount);
//    			return;
//    		case Withdrawal:
//    			cl.getClientAccount().withdraw(moneyAmount);
//    			return;
//    		default:
//    			throw new UnrecAccOpCustException();
//	    }
    			
	    if ( operationType == OperationType.Deposit )
    		cl.getClientAccount().deposit(moneyAmount);
    	else if ( operationType == OperationType.Withdrawal )
    		cl.getClientAccount().withdraw(moneyAmount);
    	else
    		throw new UnrecAccOpCustException();
	    
	    return;
    }
	
}
