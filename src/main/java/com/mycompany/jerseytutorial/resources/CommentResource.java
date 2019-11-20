/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.resources;

import com.mycompany.jerseytutorial.models.Comment;
import com.mycompany.jerseytutorial.services.CommentService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author wad-lecturer
 */

@Path("/comments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

    private CommentService CommentService = new CommentService();
	
    @GET
    public List<Comment> getComments(@PathParam("messageID") int id) {
        System.out.println("getAllCommentsForMessage..."+id);
	return CommentService.getAllComments();
    }
	
    @GET
    @Path("/{commentID}")
    public Comment getComment(@PathParam("commentID") int id) {
    	System.out.println("getCommentByID..."+id);
	return CommentService.getCommentByID(id);
    }
    
}
