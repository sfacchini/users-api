/**
 * 
 */
package edu.elal.usersapi.controller;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.elal.usersapi.model.User;
import edu.elal.usersapi.services.UsersService;

/**
 * @author sfacchini
 *
 */
@Component
@Path("/users")
public class UserController {
	
	@Autowired
	private UsersService servicio;
	
	public UserController(UsersService userService){
		this.servicio = userService;
	}
	
	@GET
	@Produces("application/json")
	public Collection<User> getAllUsers(){
		return this.servicio.getAllUsers();
	}
	
	@GET
	@Produces("application/json")
	@Path("/{id}")
	public User getUser(@PathParam("id") Long id){
		return this.servicio.getUser(id);
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response addUser(User user){
		this.servicio.addUser(user);
		return Response.created(URI.create("/" + user.getId())).build();
	}
	

}
