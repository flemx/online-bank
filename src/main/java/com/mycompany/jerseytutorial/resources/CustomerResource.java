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
@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    
    
    /**
     *  Return all customers
     * @param id
     * @return 
     */
    @GET
    public List<Customer> getCustomers(@PathParam("getCustomers") int id) {
        System.out.println("getAllCustomers..."+id);
	return CustomerService.getAllCustomers();
    }

    /**
     *  Return customer by customer id
     * @param id
     * @return 
     */
    @GET
    @Path("/{customerID}")
    public Customer getCustomer(@PathParam("customerID") int id) {
    	System.out.println("geCustomer..."+id);
	return CustomerService.geCustomer(id);
    }
    
    /**
     * Return all accounts from customer by ID
     * @param id
     * @return 
     */
    @GET
    @Path("/{customerID}/accounts")
    public List<Account> getCustomerAccounts(@PathParam("customerID") int id) {
	return CustomerService.geCustomerAccounts(id);
    }
    
    /**
     *  Create new customer
     * @param c
     * @return 
     */
    @POST
    public Customer postCustomer(Customer c) {
	return CustomerService.createCustomer(c);
    }
  
    
}
