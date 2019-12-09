/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.resources;

import com.mycompany.jerseytutorial.models.*;
import com.mycompany.jerseytutorial.services.*;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Damien Fleminks, Anthony Ennis
 */
@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {
    
    
    /**
     *  Return all accounts
     * @return 
     */
    @GET
    public List<Account> getAccounts() {
	return AccountService.getAllAccounts();
    }
    
    /**
     *  Return account object based on account number
     * @param id
     * @return 
     */
    @GET
    @Path("/{accountNumber}")
    public Account getAccount(@PathParam("accountNumber") int id) {
	return AccountService.getAccount(id);
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    @GET
    @Path("/{accountNumber}/transactions")
    public List<Transaction> getAccountTransactions(@PathParam("accountNumber") int id) {
	return AccountService.getAccountTransactions(id);
    }
    
    /**
     *  CReate new Account
     * @param a
     * @return 
     */
    @POST
    public Account postCustomer(Account a) {
	return AccountService.createAccount(a);
    }
}
