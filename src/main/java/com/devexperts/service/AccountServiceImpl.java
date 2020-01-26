package com.devexperts.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devexperts.account.Account;
import com.devexperts.account.AccountKey;
import com.devexperts.exception.InsuficientAmountException;
import com.devexperts.repository.MockRepository;

@Service
public class AccountServiceImpl implements AccountService {

    //New behaviour focused on performance
    private Map<AccountKey, Account> mapOfAccounts = new ConcurrentHashMap<AccountKey, Account>();
    
    @Autowired
    MockRepository mock;
    
    @PostConstruct
    public void init() {
    	mapOfAccounts = mock.loadAccounts();
    }

    @Override
    public void clear() {
        mapOfAccounts.clear();
    }

    @Override
    public void createAccount(Account account) {
    	mapOfAccounts.put(account.getAccountKey(), account);
    }

    @Override
    public Account getAccount(long id) {
    	return mapOfAccounts.get(AccountKey.valueOf(id));
    }

    /* To avoid the synchronized keyword, which is not quite good in performance (Only one thread executes it per time).
    Would rather create a ConcurrentHashMap with the accounts that are being used right now.
    So, before doing the transfer, the source and target account would be inserted in this map and it would be used to control
    the accounts that are currently in use. After the transfer occurs, these accounts should be removed from the map
    Also needed to perform a get in this map before actually doing the transfer and wait if it's in use. 
    Still, there's a chance of failing, but a really small one.*/
    @Override
    public synchronized void transfer(Account source, Account target, double amount) throws InsuficientAmountException {
        subtractMoneyFromAccount(source, amount);
        addMoneyToAccount(target, amount);
    }
    
    public void subtractMoneyFromAccount(Account source, double amount) throws InsuficientAmountException{
    	if(source.getBalance() < amount)
        	throw new InsuficientAmountException();
    	Double currentBalance = source.getBalance();
        double newBalance = currentBalance - amount;
        source.setBalance(newBalance);
    }
    
    public void addMoneyToAccount(Account target, double amount) {
    	Double currentBalance = target.getBalance();
        double newBalance = currentBalance + amount;
        target.setBalance(newBalance);
    }
    
}
