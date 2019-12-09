/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Damien Fleminks, Anthony Ennis
 */
public class Customer {
    
    private int id;
    private String Name;
    private Date created;
    private String Address;
    private String Email;
    private List<Account> tAccounts;
    
    //Constructor - Accounts to be added through setter
    public Customer(int id, String Name, String Address, String Email) {
        this.id = id;
        this.Name = Name;
        this.created = new Date();;
        this.Address = Address;
        this.Email = Email;
        this.tAccounts = new ArrayList<Account>();
    }
 

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public List<Account> getAccounts() {
        return tAccounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.tAccounts = accounts;
    }
    
    
    
    
    
    
}
