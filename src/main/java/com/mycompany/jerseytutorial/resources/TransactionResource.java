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
 * @author Damien Fleminks
 */
@Path("/transactions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {
    
    @GET
    public List<Transaction> getTransactions() {
	return TransactionService.getAllTransactions();
    }
    
    @GET
    @Path("/{transactionId}")
    public Transaction getTransaction(@PathParam("transactionId") int id) {
	return TransactionService.getTransaction(id);
    }
    
    @POST
    public Transaction postTransaction(Transaction c) {
	return TransactionService.createTransaction(c);
    }
  
    
}
