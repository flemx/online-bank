/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.models;

import java.util.Date;
import java.util.List;
import types.*;

/**
 *
 * @author dfleminks
 */
public class Transaction {
    
    private int id;
    private int accountNumber;
    private int amount;
    private TransType type;
    private int PostTransBalance;
    private Date created;
    //private List<Transfer> transfers;

    public Transaction(int id, int accountNumber, int amount, TransType type, int PostTransBalance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
        this.PostTransBalance = PostTransBalance;
        this.created = new Date();
    }

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TransType getType() {
        return type;
    }

    public void setType(TransType type) {
        this.type = type;
    }

    public int getPostTransBalance() {
        return PostTransBalance;
    }

    public void setPostTransBalance(int PostTransBalance) {
        this.PostTransBalance = PostTransBalance;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    
    
    
    
}
