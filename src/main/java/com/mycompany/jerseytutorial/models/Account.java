/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.models;

import java.util.Date;
import java.util.List;

/**
 *
 * @author dfleminks
 */
public class Account {
    
    private int accountNumber;
    private int customerId;
    private String sortCode;
    private String accountType;
    //private double balance;
    private Date created;
    //private List<Transaction> transactions;

    //Constructor - Transactions to be added through setter
    public Account(int accountNumber, int customerId, String sortCode, String accountType) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.sortCode = sortCode;
        this.accountType = accountType;
        this.created = new Date();
    }

    public Account() {
    }
    
    


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

//    public int getBalance() {
//        Double balance = new Double();
//        for(Transaction tran: transactions){
//            balance = balance + tran.amount;
//        }
//        return balance;
//    }


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    
    
    
    
    
}
