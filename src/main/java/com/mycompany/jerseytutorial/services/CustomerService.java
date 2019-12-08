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
import java.util.Date;

/**
 *
 * @author dfleminks
 */
public class CustomerService {
    
      private static final Database d = new Database();
      private static final List<Customer> list = d.getCustomersDB();
     
       public static List<Customer> getAllCustomers() {
        return list;
    }

        
    public static Customer geCustomer(int id) {
        for(Customer c: list){
             if(c.getId() == id){
                 return c;
             }
         }
         return null;
    }
    
    public static List<Account> geCustomerAccounts(int id) {
        try{
             return geCustomer(id).getAccounts();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }        
    }
    
    public static Customer createCustomer(Customer c){
        c.setId(list.get(list.size()-1).getId() + 1);
        c.setCreated(new Date());
        list.add(c);
        return c;
    }
    
  
}
