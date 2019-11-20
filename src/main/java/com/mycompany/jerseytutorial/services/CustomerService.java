/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.services;


import com.mycompany.jerseytutorial.databases.Database;
import com.mycompany.jerseytutorial.models.Customer;
import com.mycompany.jerseytutorial.models.Message;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dfleminks
 */
public class CustomerService {
    
      private static Database d = new Database();
      private static List<Customer> list = d.getCustomersDB();
      
       public static List<Customer> getAllCustomers() {
        return list;
    }

        
    public static Customer geCustomer(int id) {
        return list.get(id-1);
    }
      
}
