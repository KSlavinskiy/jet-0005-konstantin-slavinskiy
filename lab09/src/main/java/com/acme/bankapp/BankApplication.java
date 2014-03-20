package com.acme.bankapp;

import com.acme.bankapp.domain.bank.Bank;
import com.acme.bankapp.domain.bank.Client;
import com.acme.bankapp.domain.bank.Gender;
import com.acme.bankapp.service.bank.BankService;
import com.acme.bankapp.util.AccountType;
import com.acme.bankapp.util.ClientNotFoundCustException;
import com.acme.bankapp.util.NoMoneyOnAccountCustException;
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
        
        // String clientId, Gender gender, String clientFirstName, String clientLastName
        Client cl = new Client( "01", Gender.FEMALE, "Li", "Qwan Gon"); 
        cl.createAccount("01", AccountType.CHECKING, 1003 );        // acc num, acc type, overdraft for checking
        cl.setInitialBalance(-1001);        // long moneyOnAcc 
        BankService.addClient( bank, cl );
       
        // String clientId, Gender gender, String clientFirstName, String clientLastName
        cl = new Client( "02", Gender.MALE, "Chon", "Do Kwan"); 
        cl.createAccount("01", AccountType.CHECKING, 12000 );        // acc num, acc type, overdraft for checking
        cl.setInitialBalance(12000);        // long moneyOnAcc 
        BankService.addClient( bank, cl );  
        
        // String clientId, Gender gender, String clientFirstName, String clientLastName
        cl = new Client( "03", Gender.UNCERTAIN, "Xij", "Kha Luin"); 
        cl.createAccount("01", AccountType.SAVINGS, 120);        // acc num, acc type, overdraft for checking
        cl.setInitialBalance(1);        // long moneyOnAcc 
        BankService.addClient( bank, cl );  
      
//        BankService.addClient( bank, new Client( "03","03",       0 ) );
//        BankService.addClient( bank, new Client( "04","04",   -5010 ) );
//        BankService.addClient( bank, new Client( "05","05",     -12 ) );
//        BankService.addClient( bank, new Client( "06","06", 1234501 ) );
//        BankService.addClient( bank, new Client( "07","07",    2414 ) );
//        BankService.addClient( bank, new Client( "08","08",    3241 ) );
        
        BankService.printBalance( bank );

        try {
        	
        	// Bank bank, String clientId, long moneyAmount, OperationType operationType 
        	BankService.modifyBank ( bank, "01", 1, OperationType.Withdrawal ); 
        	BankService.modifyBank ( bank, "02", 1, OperationType.Deposit ); 
        	BankService.modifyBank ( bank, "03", 1, OperationType.Withdrawal ); 
        	//BankService.modifyBank ( bank, "04", 1, OperationType.Deposit ); // test of the exception
        	//BankService.modifyBank ( bank, "03", 1, OperationType.Credit ); // test of the exception
        	
        } catch ( ClientNotFoundCustException e ) {
        	System.out.println( "ClientNotFoundCustException: " + e );
        } catch ( UnrecAccOpCustException e ) {
        	System.out.println( "UnrecAccOpCustException: " + e );
	    } catch ( NoMoneyOnAccountCustException e ) {
	    	System.out.println( "NoMoneyOnAccountCustException: " + e );
	    }

       	System.out.println("Modified bank\n");
        BankService.printBalance( bank );
 
        System.out.println("\nMaximum withdrawal\n");
        BankService.printMaximumAmountToWithdraw(bank);
        
    }
    
}

