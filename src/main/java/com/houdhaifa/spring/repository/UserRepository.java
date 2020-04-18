/**
 * 
 */
package com.houdhaifa.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houdhaifa.spring.entity.User;

/**
 * @author Houdhaifa Hamza
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>{
	
	/**
	 * 
	 * @param name
	 * @return user by name
	 */
	 User findByName(String name);
	 
	 /**
	  * 
	  * @param email
	  * @return user by email 
	  */
	 User findByEmail(String email);

}
