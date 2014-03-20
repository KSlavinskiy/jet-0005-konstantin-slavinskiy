package com.acme.bankapp.domain.bank;

import com.acme.bankapp.util.NoMoneyOnAccountCustException;

public class SavingsAccount extends AbstractAccount {
	
	
	public void deposit( double amount ) {
		this.balance += amount;
	}
	
	public void withdraw (double amount) {
		this.balance -= amount;
	}

	
	public long maximumAmountToWithdraw() {
		
		return balance;
	}
	
	public long getBalance() {
		return balance;
	}
	
	public void withdraw (long amount) throws NoMoneyOnAccountCustException {
		
		if ( amount <= this.balance )
			this.balance -= amount;
		else
			throw new NoMoneyOnAccountCustException();
	}

}
