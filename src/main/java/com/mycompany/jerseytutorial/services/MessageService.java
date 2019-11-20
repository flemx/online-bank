/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.services;

import com.mycompany.jerseytutorial.databases.Database;
import com.mycompany.jerseytutorial.models.Message;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manueltovaizquierdo
 */
public class MessageService {
          
    Database d = new Database();
    private List<Message> list = d.getMessagesDB();
    
    public List<Message> getAllMessages() {
        return list;
    }
    
    public List<Message> getSearchMessages(String message, String author) {
        List<Message> matcheslist = new ArrayList<>();
        
        for (Message q: getAllMessages()) {
            if ((message == null || q.getMessage().equals(message)) 
                   && (author == null || q.getAuthor().equals(author))) {
               matcheslist.add(q);
            }
        }
        return matcheslist;
    }
        
    public Message getMessage(int id) {
        return list.get(id-1);
    }
    
    public Message createMessage(Message m) {
	m.setId(list.size() + 1);
	list.add(m);
	System.out.println("201 - resource created with path: /messages/" + String.valueOf(m.getId()));
	return m;
    }
    
    
}
