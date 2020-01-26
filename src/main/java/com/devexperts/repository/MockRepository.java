package com.devexperts.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.devexperts.account.Account;
import com.devexperts.account.AccountKey;

@Repository
public class MockRepository {
	
	private Map<AccountKey, Account> mapOfAccounts = new ConcurrentHashMap<AccountKey, Account>();

	public Map<AccountKey, Account> loadAccounts() {
		mapOfAccounts.put(AccountKey.valueOf(1), new Account(AccountKey.valueOf(1), "Felipe", "Almeida", 500d));
		mapOfAccounts.put(AccountKey.valueOf(2), new Account(AccountKey.valueOf(2), "João", "Riso", 400d));
		mapOfAccounts.put(AccountKey.valueOf(3), new Account(AccountKey.valueOf(3), "Michelle", "Morais", 300d));
		mapOfAccounts.put(AccountKey.valueOf(4), new Account(AccountKey.valueOf(4), "Luciana", "Correa", 1000d));
		mapOfAccounts.put(AccountKey.valueOf(5), new Account(AccountKey.valueOf(5), "Client", "5", 5000d));
		mapOfAccounts.put(AccountKey.valueOf(6), new Account(AccountKey.valueOf(6), "Client", "6", 200d));
		mapOfAccounts.put(AccountKey.valueOf(7), new Account(AccountKey.valueOf(7), "Client", "7", 500d));
		mapOfAccounts.put(AccountKey.valueOf(8), new Account(AccountKey.valueOf(8), "Client", "8", 700d));
		mapOfAccounts.put(AccountKey.valueOf(9), new Account(AccountKey.valueOf(9), "Client", "9", 1000000d));
		mapOfAccounts.put(AccountKey.valueOf(10), new Account(AccountKey.valueOf(10), "Client", "10", 100d));
		return mapOfAccounts;
	}

}
