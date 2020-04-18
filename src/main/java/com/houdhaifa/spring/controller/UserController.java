/**
 * 
 */
package com.houdhaifa.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.houdhaifa.spring.entity.User;
import com.houdhaifa.spring.service.UserService;

/**
 * @author Houdhaifa Hamza
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		User userEntity = userService.getUserByEmail(user.getEmail());
		if (userEntity == null) {
			userService.saveUser(user);
			return "User successfully registered";
		} else {
			throw new RuntimeException("User already exist");
		}

	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getUsers();
	}

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}

	@GetMapping("/user/{name}")
	public User getUserByName(@PathVariable String name) {
		return userService.getUserByName(name);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable Integer id) {
		return userService.deleteUser(id);
	}

	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

}
