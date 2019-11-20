/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.services;

import com.mycompany.jerseytutorial.databases.Database;
import com.mycompany.jerseytutorial.models.Comment;
import com.mycompany.jerseytutorial.models.Message;
import java.util.List;

/**
 *
 * @author wad-lecturer
 */
public class CommentService {
    
    private List<Message> mlist = new Database().getMessagesDB();
    private List<Comment> clist = new Database().getCommentsDB();
    
    public List<Comment> getAllComments() {
        return clist;
    }
    
    public List<Comment> getAllCommentsByMessage(int MessageID) {
        return mlist.get(MessageID-1).getComments();
    }
    
    public Comment getCommentByID(int id) {
        return clist.get(id-1);
    }
    
}
