/**
 * 
 */
package edu.elal.usersapi.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

import edu.elal.usersapi.model.User;

/**
 * @author sfacchini
 *
 */
@Service
public class UserServiceImpl implements UsersService {
	
	private final ConcurrentMap<Long, User> users;
	
	public UserServiceImpl(){
		this.users = new ConcurrentHashMap<Long, User>(); 
	}

	/* (non-Javadoc)
	 * @see edu.elal.usersapi.services.UsersService#getAllUsers()
	 */
	@Override
	public Collection<User> getAllUsers() {
		Collection<User> allUsers = users.values();
		return allUsers.isEmpty() ? Collections.emptyList():new ArrayList<>(allUsers);
	}

	/* (non-Javadoc)
	 * @see edu.elal.usersapi.services.UsersService#getUser(java.lang.Long)
	 */
	@Override
	public User getUser(Long id) {
		return users.get(id);
	}

	/* (non-Javadoc)
	 * @see edu.elal.usersapi.services.UsersService#addUser(edu.elal.usersapi.model.User)
	 */
	@Override
	public void addUser(User user) {
		users.put(user.getId(), user);

	}

	/* (non-Javadoc)
	 * @see edu.elal.usersapi.services.UsersService#updateUser(java.lang.Long, edu.elal.usersapi.model.User)
	 */
	@Override
	public void updateUser(Long id, User user) {
		users.put(id, user);

	}

	/* (non-Javadoc)
	 * @see edu.elal.usersapi.services.UsersService#deleteUser(java.lang.Long)
	 */
	@Override
	public void deleteUser(Long id) {
		users.remove(id);

	}

}
