/**
 * 
 */
package com.mycompany.jerseytutorial.models;

import java.util.Date;
import java.util.List;
import types.*;

/**
 *
 * @author Damien Fleminks, Anthony Ennis
 */
public class Account {
    
    private int accountNumber;
    private int customerId;
    private String customerName;
    private String sortCode;
    private AccountType accountType;
    private int balance;
    private Date created;
    private List<Transaction> transactions;

    //Constructor - Transactions to be added through setter
    public Account(int accountNumber, int customerId, String sortCode, AccountType accountType, List<Transaction> transactions, int balance, String customerName) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.sortCode = sortCode;
        this.accountType = accountType;
        this.created = new Date();
        this.transactions = transactions;
        this.customerName = customerName;
        
        // Generate balance from sum of transactions
        for(Transaction tran: transactions){
            this.balance = this.balance + tran.getAmount();
        }
        
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

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    
    /**
     *  Return balance based on sum of transactions
     * @return 
     */
    public int getBalance() {
        int theBalance = 0;
        for(Transaction tran: transactions){
           theBalance = theBalance + tran.getAmount();
        }
        return theBalance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    
    
    
    
}
