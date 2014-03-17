package com.acme.bankapp;

public class AbstractAccount implements Account {
	
	private String account;
	private long balance;
	
	public void deposit( long amount ) {
		this.balance += amount;
	}
	
	public void withdraw (long amount) {
		this.balance -= amount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the balance
	 */
	public long getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(long balance) {
		this.balance = balance;
	}
}
