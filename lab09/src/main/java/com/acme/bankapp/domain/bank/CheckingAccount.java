package com.acme.bankapp.domain.bank;

import com.acme.bankapp.util.NoMoneyOnAccountCustException;

public class CheckingAccount extends AbstractAccount {
	
	private long overdraft;

	/**
	 * @return the overdraft
	 */
	public long getOverdraft() {
		return overdraft;
	}

	/**
	 * @param overdraft the overdraft to set
	 */
	public void setOverdraft(long overdraft) {
		this.overdraft = overdraft;
	}

	public void deposit( double amount ) {
		this.balance += amount;
	}

	public void withdraw (double amount) {
		this.balance -= amount;
	}
	
	public long maximumAmountToWithdraw() {
		
		return balance + overdraft;
		
	}
	
	public long getBalance() {
		return balance + overdraft;
	}
	
	public void withdraw (long amount) throws NoMoneyOnAccountCustException {
		
		long total = this.balance + this.overdraft;
		
		if ( amount <= total ) {
			
			if ( amount <= this.balance ) 
				this.balance -= amount;
			else {
				total -= amount;
				this.balance = 0;
				this.overdraft = total;					
			}
			
		}
		else
			throw new NoMoneyOnAccountCustException();
	}
	
}



