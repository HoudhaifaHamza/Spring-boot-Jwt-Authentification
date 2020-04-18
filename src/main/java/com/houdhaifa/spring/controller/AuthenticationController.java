/**
 * 
 */
package com.houdhaifa.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.houdhaifa.spring.entity.AuthRequest;
import com.houdhaifa.spring.util.JwtTokenUtil;

/**
 * @author Houdhaifa Hamza
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthenticationController {
	
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/home")
	public Boolean welcome() {
		return true;
	}
	
	@PostMapping("/authenticate")
	public String generateToken (@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		}
		catch (Exception e) {
			throw new Exception("Invalid email/password") ;
		}
		
		return jwtTokenUtil.generateToken(authRequest.getEmail());
	}
	
	
	

}
