package com.acme.bankapp.domain.bank;

import com.acme.bankapp.util.NoMoneyOnAccountCustException;

public interface Account {
	
	void deposit( long amount );
	void withdraw( long amount) throws NoMoneyOnAccountCustException ;
	
	void deposit( double amount );
	void withdraw( double amount);
	
	long maximumAmountToWithdraw();
	
}
