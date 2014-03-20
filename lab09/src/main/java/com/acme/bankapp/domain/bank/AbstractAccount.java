package com.acme.bankapp.domain.bank;


abstract public class AbstractAccount implements Account {
	
	private String account;
	protected long balance;
	
	// abstract methods
	abstract public long getBalance();
	
	public void deposit( long amount ) {
		this.balance += amount;
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(long balance) {
		this.balance = balance;
	}
}
