package com.acme.bankapp.domain.bank;

public interface Account {
	void deposit( long amount );
	void withdraw( long amount);

}
