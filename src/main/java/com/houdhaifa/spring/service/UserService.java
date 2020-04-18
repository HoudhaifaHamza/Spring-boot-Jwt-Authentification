/**
 * 
 */
package com.houdhaifa.spring.service;

import java.util.List;

import com.houdhaifa.spring.entity.User;

/**
 * @author Houdhaifa Hamza
 *
 */
public interface UserService {

	/**
	 * 
	 * @param user
	 * @return User method to save one user
	 */
	public User saveUser(User user);

	/**
	 * 
	 * @return List of users method to fin all users
	 */
	public List<User> getUsers();

	/**
	 * 
	 * @param id
	 * @return User method to find user by Id
	 */
	public User getUserById(Integer id);

	/**
	 * 
	 * @param name
	 * @return User method to find user by name
	 */
	public User getUserByName(String name);

	
	/**
	 * 
	 * @param email
	 * @return User method to find user by email
	 */
	public User getUserByEmail(String email);

	/**
	 * 
	 * @param id
	 * @return method to delete a user
	 */
	public String deleteUser(Integer id);

	/**
	 * 
	 * @param user
	 * @return User method to update a user
	 */
	public User updateUser(User user);
	
	

}
