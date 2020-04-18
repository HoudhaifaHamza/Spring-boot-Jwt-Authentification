/**
 * 
 */
package com.houdhaifa.spring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.houdhaifa.spring.entity.User;
import com.houdhaifa.spring.repository.UserRepository;
import com.houdhaifa.spring.service.UserService;

/**
 * @author Houdhaifa Hamza
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User getUserByName(String name) {
		return userRepository.findByName(name);
	}
	
	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public String deleteUser(Integer id) {
		userRepository.deleteById(id);
		return "user removed" + id;
	}

	@Override
	public User updateUser(User user) {
		User updatedUser = userRepository.findById(user.getId()).orElse(null);
		updatedUser.setName(user.getName());
		updatedUser.setEmail(user.getEmail());
		updatedUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		updatedUser.setRole(user.getRole());
		return updatedUser;
	}

}
