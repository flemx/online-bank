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
 * @author wsapi-lecturer
 */
public class Database {
    public static List<Message> messageDB = new ArrayList<>();
    public static List<Comment> commentDB = new ArrayList<>();
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
        
        int accCount = 0;
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
                    int balanceSum = 0;
                    
                    for(Transaction tr : transactions){
                        balanceSum = balanceSum + tr.getAmount();
                    }
                    Transaction tran = new Transaction(
                            tranCount,
                            i+j,
                            randomBalance,
                            transactionTypes.get(k),
                            balanceSum + randomBalance
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
          
          
          
        // Lets create some comments
        Comment c1 = new Comment (1,"One comment");  
        Comment c2 = new Comment (2,"Another comment");
        Comment c3 = new Comment (3,"And another comment more");
        
        commentDB.add(c1);
        commentDB.add(c2);
        commentDB.add(c3);
        
        // Lets add those comments to each of the messages. 
        // Keep in mind ALL messages will contain same list of seeded comments!!!
        Message m1 = new Message(1,"First", "Manuel", commentDB);
        Message m2 = new Message(2,"Second", "Jack", commentDB);        
        Message m3 = new Message(3,"Third", "Emer", commentDB);
        Message m4 = new Message(4,"First", "Lisa", commentDB);
        Message m5 = new Message(5,"Fifth", "Jack", commentDB);
        
        messageDB.add(m1);
        messageDB.add(m2);
        messageDB.add(m3);
        messageDB.add(m4);
        messageDB.add(m5);
        
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
     
     
    
    public static List<Message> getMessagesDB() {
        return messageDB;
    }
    
    public static List<Comment> getCommentsDB() {
        return commentDB;
    }
}
