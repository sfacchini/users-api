/**
 * 
 */
package edu.elal.usersapi.services;

import java.util.Collection;

import edu.elal.usersapi.model.User;

/**
 * @author sfacchini
 *
 */
public interface UsersService {
	
	Collection<User> getAllUsers();
	
	User getUser(Long id);
	
	void addUser(User user);
	
	void updateUser(Long id, User user);
	
	void deleteUser(Long id);
	

}
