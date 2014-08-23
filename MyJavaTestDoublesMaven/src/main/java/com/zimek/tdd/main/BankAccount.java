package com.zimek.tdd.main;

import java.math.BigDecimal;

public interface BankAccount {
	public long getAccountId();
	public void setAccountId(long accountId);
	public void setBalance(BigDecimal balance);
	public BigDecimal getBalance();
	public void withdraw(BigDecimal amount);
	public void deposit(BigDecimal amount);
}
