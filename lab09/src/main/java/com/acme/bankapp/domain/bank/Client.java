package com.acme.bankapp.domain.bank;


//import java.util.TreeMap;

//import com.acme.bankapp.util.ClientNotFoundCustException;
//import com.acme.bankapp.util.OperationType;
//import com.acme.bankapp.util.UnrecAccOpCustException;

public class Client {
	
	private String clientId;
	private AbstractAccount clientAccount;
	private long clientBalance;
	
	private Gender gender;	
	private String clientFirstName;
	private String clientLastName;
//	private String clientDescription;
//	private String clientAddress;
	
	public Client( String clientId, String account, long moneyOnAcc ) {

		this.clientId = clientId;

		this.clientAccount = new AbstractAccount() ;
		this.clientAccount.setAccount(account);
		this.clientAccount.deposit(moneyOnAcc);
		
		// a possible future use as a sum of all account balances (if there are many)
		//this.setClientBalance(clientBalance);
		
	}

	public Client( 
			String clientId, 
			String account, 
			long moneyOnAcc,
			Gender gender, 
			String clientFirstName, 
			String clientLastName  ) {

		this.clientId = clientId;

		this.clientAccount = new AbstractAccount() ;
		this.clientAccount.setAccount(account);
		this.clientAccount.deposit(moneyOnAcc);

		this.gender = gender; 
		this.clientFirstName = clientFirstName; 
		this.clientLastName = clientLastName; 
		
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


	public long getClientBalance() {
		return clientBalance;
	}


	public void setClientBalance(long clientBalance) {
		this.clientBalance = clientBalance;
	}

	
}
