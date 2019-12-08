/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.services;

import com.mycompany.jerseytutorial.databases.Database;
import com.mycompany.jerseytutorial.models.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author tonyennis, damien fleminks
 */
public class AccountService {
    
     private static Database d = new Database();
     private static List<Account> list = d.getAccountDB();
     
     
  
     
      /**
      * Return all accounts from database
      * @return 
      */
     public static List<Account> getAllAccounts(){
         return list;
     }
     
     /**
      * Return account by accountNumber
      * @return 
      */
     public static Account getAccount(int accountNumber){
         for(Account a: list){
             if(a.getAccountNumber() == accountNumber){
                 return a;
             }
         }
         return null;
     }
     
    
     /**
      *  Find 
      * @param accountId
      * @return 
      */
    public static List<Transaction> getAccountTransactions(int accountNumber) {
        try{
             return getAccount(accountNumber).getTransactions();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
      
    
}
