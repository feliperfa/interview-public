package com.devexperts.rest;

import org.springframework.http.ResponseEntity;

import com.devexperts.exception.AccountNotFoundException;
import com.devexperts.exception.InsuficientAmountException;

public abstract class AbstractAccountController {
    abstract ResponseEntity<Void> transfer(long sourceId, long targetId, double amount) throws InsuficientAmountException, AccountNotFoundException;
}
