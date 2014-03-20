package com.acme.bankapp.domain.bank;

import com.acme.bankapp.util.AccountType;

public class Client {
	
	private String clientId;
	private AbstractAccount clientAccount;
	
	// a possible future use as a sum of all account balances (if there are many)
	//private long clientBalance;
	
	private Gender gender;	
	private String clientFirstName;
	private String clientLastName;
//	private String clientDescription;
//	private String clientAddress;
	
	public Client( 
			String clientId, 
			Gender gender, 
			String clientFirstName, 
			String clientLastName  ) {
		
		this.clientId = clientId;
		this.gender = gender; 
		this.clientFirstName = clientFirstName; 
		this.clientLastName = clientLastName; 
		
	}
	
	public void createAccount ( String account, AccountType accountType, long overdraft ) {
		
		if (accountType == AccountType.SAVINGS) {
			this.clientAccount = new SavingsAccount() ;
		}
		else if(accountType == AccountType.CHECKING) {
			this.clientAccount = new CheckingAccount();
			( (CheckingAccount) this.clientAccount ).setOverdraft(overdraft);
		}

		this.clientAccount.setAccount(account);

	}
	
	public void setInitialBalance(long moneyOnAcc) {
		this.clientAccount.setBalance(moneyOnAcc);

	}
	
	
	public String getClientSalutation () {
		
		return this.gender.getSalutation() + " " + this.clientFirstName + " " + this.clientLastName;
	}
	
	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the clientFirstName
	 */
	public String getClientFirstName() {
		return clientFirstName;
	}

	/**
	 * @param clientFirstName the clientFirstName to set
	 */
	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}

	/**
	 * @return the clientLastName
	 */
	public String getClientLastName() {
		return clientLastName;
	}

	/**
	 * @param clientLastName the clientLastName to set
	 */
	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
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
}
