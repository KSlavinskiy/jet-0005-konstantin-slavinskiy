/**
 * 
 */
package com.acme.bankapp.domain.bank;

/**
 * @author Konstantin
 *
 */
public enum Gender {
	
	MALE("Mr."), FEMALE("Ms."), UNCERTAIN ("Human");
	
	private String salutation;
	
	Gender (String salutation) {
		this.salutation = salutation;
	}
	
	String getSalutation() {
		return this.salutation;
	}
	

}
