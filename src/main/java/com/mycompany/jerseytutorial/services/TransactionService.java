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
 * @author damien fleminks
 */
public class TransactionService {
    
     private static Database d = new Database();
     private static List<Transaction> list = d.getTransactionDB();
     
    
     /**
      * Return all Transactions
      * @return 
      */
    public static List<Transaction> getAllTransactions(){
            return list;
    }
    
    /**
     * Return single Transaction by id
     * @param id
     * @return 
     */
    public static Transaction getTransaction(int id){
         for(Transaction t: list){
             if(t.getId() == id){
                 return t;
             }
         }
         return null;
    }
        
    
}
