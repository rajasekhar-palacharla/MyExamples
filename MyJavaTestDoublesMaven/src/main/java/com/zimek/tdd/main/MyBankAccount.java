package com.zimek.tdd.main;

import java.math.BigDecimal;

public class MyBankAccount implements BankAccount {
	
	private BigDecimal balance = new BigDecimal(0.0);
	private long accountId = 0L;
	
	public MyBankAccount(BigDecimal initAmount, long id) {
		this.balance = initAmount;
		this.accountId = id;
	}
	
	@Override
	public void deposit(BigDecimal amount) {
		balance = balance.add(amount);
	}
	
	@Override
	public void withdraw(BigDecimal amount) {
		if (amount.compareTo(balance) == 1) {
			throw new IllegalArgumentException("Insufficient funds!");
		}
		balance = balance.subtract(amount);
	}
	
	@Override
	public BigDecimal getBalance() {
		return balance;
	}
	
	@Override
	public long getAccountId() {
		return accountId;
	}
	
	@Override
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	
	@Override
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
