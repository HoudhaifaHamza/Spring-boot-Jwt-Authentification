/**
 * 
 */
package com.houdhaifa.spring.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.houdhaifa.spring.entity.User;
import com.houdhaifa.spring.repository.UserRepository;

/**
 * @author Hamza Houdhaifa
 *
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		CustomUserDetails userDetails = null;
		if (user != null) {
			userDetails = new CustomUserDetails();
			userDetails.setUser(user);
		} else {
			throw new UsernameNotFoundException("User " + user + " not exist");
		}
		userDetails.setUser(user);
		return userDetails;
	}

}
