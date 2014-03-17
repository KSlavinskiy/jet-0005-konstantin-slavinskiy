package com.acme.bankapp;

public class Client {
	
	private String clientId;
	private AbstractAccount clientAccount;
	private long clientBalance;
	
// private String gender;	
//	private String clientFirstName;
//	private String clientLastName;
//	private String clientDescription;
//	private String clientAddress;
	
	public Client( String clientId, String account, long moneyOnAcc ) {

		this.clientId = clientId;

		this.clientAccount = new AbstractAccount() ;
		this.clientAccount.setAccount(account);
		this.clientAccount.deposit(moneyOnAcc);
		
		//this.setClientBalance(clientBalance);

	}


	public String getClientId() {
		return clientId;
	}


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	public AbstractAccount getClientAccount() {
		return clientAccount;
	}


	public void setClientAccount(AbstractAccount clientAccount) {
		this.clientAccount = clientAccount;
	}


	public long getClientBalance() {
		return clientBalance;
	}


	public void setClientBalance(long clientBalance) {
		this.clientBalance = clientBalance;
	}

	
}
