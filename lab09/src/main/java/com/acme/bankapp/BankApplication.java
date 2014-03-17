package com.acme.bankapp;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.acme.bankapp.util.ClientNotFoundCustException;
import com.acme.bankapp.util.MoneyFormatter;
import com.acme.bankapp.util.OperationType;
import com.acme.bankapp.util.UnrecAccOpCustException;



/**
 * BankApplication!
 *
 */
public class BankApplication 
{
    public static void main( String[] args ) {
    	
        Bank bank = new Bank();
        bank.addClient( new Client( "01","01",   -1001 ) ); // Client( String clientId, String account, long moneyOnAcc )
        bank.addClient( new Client( "02","02",   12000 ) );
//        bank.addClient( new Client( "03","03",       0 ) );
//        bank.addClient( new Client( "04","04",   -5010 ) );
//        bank.addClient( new Client( "05","05",     -12 ) );
//        bank.addClient( new Client( "06","06", 1234501 ) );
//        bank.addClient( new Client( "07","07",    2414 ) );
//        bank.addClient( new Client( "08","08",    3241 ) );
        
        BankApplication.printBalance( bank );
        
        try {
        	modifyBank ( bank, "01", 1, OperationType.Withdrawal ); 
        	//modifyBank ( bank, "10", -1, OperationType.Withdrawal ); 
        	modifyBank ( bank, "02", 1, OperationType.Deposit ); 
        	//modifyBank ( bank, "01", 1, OperationType.Credit ); 
        	
        } catch ( ClientNotFoundCustException e ) {
        	System.out.println( "ClientNotFoundCustException: " + e );
        } catch ( UnrecAccOpCustException e ) {
        	System.out.println( "UnrecAccOpCustException: " + e );
        }
        
        System.out.println("Modified bank\n");
        BankApplication.printBalance( bank );
        
    }
    
    static void printBalance( Bank bank ) {

    	Set< Map.Entry <String, Client> > tm = bank.getClients().entrySet();
    	for ( Map.Entry <String, Client> me : tm ) {
        	System.out.println( "Client key: " + me.getKey() ); 
        	System.out.println( "Client id: " + me.getValue().getClientId() ); 
        	System.out.println( "Client account: " + me.getValue().getClientAccount().getAccount() ); 
         	//printing the balance
        	System.out.println( "Client balance: " + 
        			new MoneyFormatter(me.getValue().getClientAccount().getBalance()).formattedMoney); 
        	System.out.println();

    	}
    	System.out.println();
    }
    
    static void modifyBank ( Bank bank, String clientId, long moneyAmount, OperationType operationType ) 
    throws UnrecAccOpCustException, ClientNotFoundCustException {
    	
    	TreeMap<String, Client> clients = bank.getClients();
    	Client cl = clients.get(clientId);
    	if( cl == null) 
			throw new ClientNotFoundCustException();
    	
    	switch (operationType) {
    	
    		case Deposit:
    			cl.getClientAccount().deposit(moneyAmount);
    			return;
    		case Withdrawal:
    			cl.getClientAccount().withdraw(moneyAmount);
    			return;
    		default:
    			throw new UnrecAccOpCustException();
    	
    	}
    }
}

