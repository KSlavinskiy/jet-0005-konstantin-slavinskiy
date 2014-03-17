package com.acme.bankapp.util;


public class MoneyFormatter {
	
	public String formattedMoney = "";
	
	public MoneyFormatter ( long money) {
		
		if ( money < 0)
			formattedMoney += "-";
		
		formattedMoney += Math.abs( money/100 );
		formattedMoney += ".";
		
		if ( Math.abs( money%100 ) < 10)
			formattedMoney += "0";
		
		formattedMoney += Math.abs( money%100 );
		
	}
	
}
