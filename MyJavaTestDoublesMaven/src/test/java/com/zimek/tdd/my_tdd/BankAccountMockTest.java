package com.zimek.tdd.my_tdd;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;

import com.zimek.tdd.main.BankAccount;

public class BankAccountMockTest {

	@Test
	public void testBankAccount() {
		BankAccount bankAcc = mock(BankAccount.class);
		when(bankAcc.getBalance()).thenReturn(new BigDecimal("15.0"));
		assertEquals(new BigDecimal("15.0"), bankAcc.getBalance());
		verify(bankAcc).getBalance();
	}
}
