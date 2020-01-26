package com.devexperts.rest;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devexperts.account.Account;
import com.devexperts.exception.AccountNotFoundException;
import com.devexperts.exception.InsuficientAmountException;
import com.devexperts.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController extends AbstractAccountController {
	
	@Autowired
	private AccountService service;

	@PostMapping(path = "/operations/transfer")
    public ResponseEntity<Void> transfer(@RequestParam long sourceId, 
    		@RequestParam long targetId, 
    		@RequestParam @Valid @Min(value = 0, message="amount value must be greather than 0") double amount) throws InsuficientAmountException, AccountNotFoundException {
        Account sourceAccount = service.getAccount(sourceId);
        Account targetAccount = service.getAccount(targetId);
        
        // Would have used Optional here, but asked to not change the methods signature.
        if(sourceAccount == null)
        	throw new AccountNotFoundException(String.format("No account with the id %d", sourceAccount));
        else if(targetAccount == null)
        	throw new AccountNotFoundException(String.format("No account with the id %d", targetAccount));
        
        service.transfer(sourceAccount, targetAccount, amount);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
}
