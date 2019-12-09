/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.databases;

import com.mycompany.jerseytutorial.models.*;
import types.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Damien Fleminks,  Anthony Ennis
 */
public class Database {
    public static List<Customer> customerDB = new ArrayList<>();
    public static List<Account> accountDB = new ArrayList<>();
    public static List<Transaction> transactionDB = new ArrayList<>();
    public static boolean init = true;
     
    // Lets create a constructor for the class
    public Database () {
      if (init) {
       
      List<AccountType> accountTypes =  Arrays.asList(AccountType.CURRENT, AccountType.SAVING, AccountType.CREDIT);
      List<TransType> transactionTypes =  Arrays.asList(TransType.DEPOSIT, TransType.TRANFSER, TransType.WITHDRAW);
          
       // Create customers
       Customer cus1 = new Customer (0,"Robin O'reily", "Dublin", "robin@email.com");  
       Customer cus2 = new Customer (1,"Mark Boontjes", "Cork", "mark@email.com");  
       Customer cus3 = new Customer (2,"Dirk de Vries", "Galway", "dirk@email.com");  

        customerDB.add(cus1);
        customerDB.add(cus2);
        customerDB.add(cus3);
        
        int accCount = 372860;
        int tranCount = 0;
        
        // Add accounts to customers with transactions
        for(int i = 0; i < customerDB.size(); i++){
            List<Account> accounts = new ArrayList<Account>();
            
            // Generate 3 Accounts
            for(int j = 0; j < 3; j++){
                List<Transaction> transactions = new ArrayList<Transaction>();
                //Generate3 transactions
                for(int k = 0; k < 3; k++){
                    int randomBalance = new Random().nextInt();
                    randomBalance = (int) randomBalance / 10000;
                    int balanceSum = 0;
                    int trasferAcc = 0;
                    if(transactionTypes.get(k) == TransType.TRANFSER){
                        trasferAcc =  accCount -2;
                    }
                    for(Transaction tr : transactions){
                        balanceSum = balanceSum + tr.getAmount();
                    }
                    Transaction tran = new Transaction(
                            tranCount,
                            accCount,
                            randomBalance,
                            transactionTypes.get(k),
                            balanceSum + randomBalance,
                            trasferAcc
                    );
                    transactions.add(tran);
                    transactionDB.add(tran);
                    tranCount++;
                }
                Account acc = new Account(
                         accCount, 
                         customerDB.get(i).getId(),
                        "BANK01",
                        accountTypes.get(j),
                        transactions,
                        0,
                        customerDB.get(i).getName());
                accounts.add(acc);
                accountDB.add(acc);
                accCount++;
            }
            customerDB.get(i).setAccounts(accounts);
        }
          
          
          
        
        init = false;
     }
    }
    
     public static List<Customer> getCustomersDB() {
        return customerDB;
    }

    public static List<Account> getAccountDB() {
        return accountDB;
    }

    public static List<Transaction> getTransactionDB() {
        return transactionDB;
    }

}
