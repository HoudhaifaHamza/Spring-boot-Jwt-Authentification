/**
 * 
 */
package com.houdhaifa.spring.serviceImpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.houdhaifa.spring.entity.User;

import lombok.Data;

/**
 * @author Houdhaifa Hamza
 *
 */
@Data
public class CustomUserDetails implements UserDetails {

	/**
	 * Serial Number for CustomUserDetails
	 */
	private static final long serialVersionUID = -3794119018656102171L;

	private User user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<String> roles = Arrays.asList(user.getRole());
		return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
