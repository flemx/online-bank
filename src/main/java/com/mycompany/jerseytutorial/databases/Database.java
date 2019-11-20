/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.databases;

import com.mycompany.jerseytutorial.models.*;
import com.mycompany.jerseytutorial.models.Message;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wsapi-lecturer
 */
public class Database {
    public static List<Message> messageDB = new ArrayList<>();
    public static List<Comment> commentDB = new ArrayList<>();
    public static List<Customer> customerDB = new ArrayList<>();
    public static boolean init = true;
     
    // Lets create a constructor for the class
    public Database () {
      if (init) {
          
          
       // Create customers
       Customer cus1 = new Customer (1,"Robin O'reily", "Dublin", "robin@email.com");  
       Customer cus2 = new Customer (2,"Mark Boontjes", "Cork", "mark@email.com");  
       Customer cus3 = new Customer (3,"Dirk de Vries", "Galway", "dirk@email.com");  

        customerDB.add(cus1);
        customerDB.add(cus2);
        customerDB.add(cus3);
          
          
          
          
          
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
    
    public static List<Message> getMessagesDB() {
        return messageDB;
    }
    
    public static List<Comment> getCommentsDB() {
        return commentDB;
    }
}
