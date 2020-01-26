/**
 * 
 */
package com.devexperts.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.devexperts.account.Account;
import com.devexperts.account.AccountKey;
import com.devexperts.exception.InsuficientAmountException;
import com.devexperts.service.AccountService;
import com.devexperts.service.AccountServiceImpl;
import static org.assertj.core.api.Assertions.*;

/**
 * @author feliperamalhofurtadodealmeida
 *
 */
public class AccountServiceTest {

	private Account source;
	private Account target;

	private AccountService underTest = new AccountServiceImpl();

	@Before
	public void mockAccounts() {
		source = new Account(AccountKey.valueOf(1), "Felipe", "Almeida", 500d);
		target = new Account(AccountKey.valueOf(2), "João", "Souza", 200d);
	}

	@Test
	public void when_amount_is_valid_should_remove_money_from_source_and_update_target() {
		try {
			underTest.transfer(source, target, 100d);
			assertThat(source.getBalance()).as("Amount for first account").isEqualTo(400d);
			assertThat(target.getBalance()).as("Amount for second account").isEqualTo(300d);
		} catch (InsuficientAmountException e) {
			Assert.fail("Should have suficient amount. Something went wrong");
		}
	}

	@Test
	public void when_amount_is_invalid_exception_should_be_thrown() {
		assertThatExceptionOfType(InsuficientAmountException.class).isThrownBy(() -> {
			underTest.transfer(source, target, 1000d);
		});
	}

}
