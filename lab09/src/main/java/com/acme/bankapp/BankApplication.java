package com.acme.bankapp;

import com.acme.bankapp.domain.bank.Bank;
import com.acme.bankapp.domain.bank.Client;
import com.acme.bankapp.domain.bank.Gender;
import com.acme.bankapp.service.bank.BankService;
import com.acme.bankapp.util.ClientNotFoundCustException;
import com.acme.bankapp.util.OperationType;
import com.acme.bankapp.util.UnrecAccOpCustException;



/**
 * BankApplication!
 *
 */
public class BankApplication 
{
    public static void main( String[] args ) {
    	
    	///// Testing lab09 Task1 /////
    	
        Bank bank = new Bank();
        BankService.addClient( bank, new Client( "01","01",   -1001 ) ); // Client( String clientId, String account, long moneyOnAcc )
        BankService.addClient( bank, new Client( "02","02",   12000 ) );
//        BankService.addClient( bank, new Client( "03","03",       0 ) );
//        BankService.addClient( bank, new Client( "04","04",   -5010 ) );
//        BankService.addClient( bank, new Client( "05","05",     -12 ) );
//        BankService.addClient( bank, new Client( "06","06", 1234501 ) );
//        BankService.addClient( bank, new Client( "07","07",    2414 ) );
//        BankService.addClient( bank, new Client( "08","08",    3241 ) );
        
    	///// Testing lab09 Task3 /////
        BankService.printBalance( bank );
    	///// Testing lab09 Task3 /////

        
        try {
        	BankService.modifyBank ( bank, "01", 1, OperationType.Withdrawal ); 
        	//modifyBank ( bank, "10", -1, OperationType.Withdrawal ); 
        	BankService.modifyBank ( bank, "02", 1, OperationType.Deposit ); 
        	//modifyBank ( bank, "01", 1, OperationType.Credit ); 
        	
        } catch ( ClientNotFoundCustException e ) {
        	System.out.println( "ClientNotFoundCustException: " + e );
        } catch ( UnrecAccOpCustException e ) {
        	System.out.println( "UnrecAccOpCustException: " + e );
        }
        
        System.out.println("Modified bank\n");
        BankService.printBalance( bank );
        
    	///// Testing lab09 Task1 /////
   //---------------------------------------------------------//     
    	///// Testing lab09 Task2 /////
        
        Client cl = new Client( "03","03", 0, Gender.FEMALE, "Li", "Qwan Gon" );
        System.out.println( cl.getClientSalutation() );
        
        cl = new Client( "04","04", 0, Gender.MALE, "Chon", "Do Kwan" );
        System.out.println( cl.getClientSalutation() );
        
        cl = new Client( "04","04", 0, Gender.UNCERTAIN, "Xij", "Kha Luin" );
        System.out.println( cl.getClientSalutation() );
       
    	///// Testing lab09 Task2 /////

        
    }
    
}

