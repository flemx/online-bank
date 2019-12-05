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
 * @author dfleminks
 */
public class CustomerService {
    
      private static Database d = new Database();
      private static List<Customer> list = d.getCustomersDB();
       private static List<Account> accounts = d.getAccountDB();
      
       public static List<Customer> getAllCustomers() {
        return list;
    }

        
    public static Customer geCustomer(int id) {
        Customer cus = list.get(id);
        return cus;
    }
    
    public static List<Account> geCustomerAccounts(int id) {
        return list.get(id).getAccounts();
    }
    
    // To be moved to Account services class!!!
    public static List<Transaction> getAccountTransactions(int accountId) {
        return accounts.get(1).getTransactions();
    }
      
}
