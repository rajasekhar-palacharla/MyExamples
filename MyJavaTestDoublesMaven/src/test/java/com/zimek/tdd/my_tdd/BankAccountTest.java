/**
 * 
 */
package com.zimek.tdd.my_tdd;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zimek.tdd.main.BankAccount;
import com.zimek.tdd.main.MyBankAccount;

public class BankAccountTest {
	
	BankAccount bankAcc = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bankAcc = new MyBankAccount(new BigDecimal(20.0), 1L);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		bankAcc = null;
	}

	@Test
	public void testWithdraw() {
		bankAcc.withdraw(new BigDecimal(10.0));
		assertEquals(new BigDecimal(10.0), bankAcc.getBalance());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWithdrawTooMuch() {
		bankAcc.withdraw(new BigDecimal(100.0));
	}
	
	@Test
	public void testDeposit() {
		bankAcc.deposit(new BigDecimal(10.0));
		assertEquals(new BigDecimal(30.0), bankAcc.getBalance());
	}
}
