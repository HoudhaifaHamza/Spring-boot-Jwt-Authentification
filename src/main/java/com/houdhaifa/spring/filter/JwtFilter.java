package com.houdhaifa.spring.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.houdhaifa.spring.serviceImpl.CustomUserDetailsService;
import com.houdhaifa.spring.util.JwtTokenUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException {

		String autorizationHeader = httpServletRequest.getHeader("Authorization");
		String token = null;
		String userName = null;

		if (autorizationHeader != null && autorizationHeader.startsWith("Bearer ")) {
			token = autorizationHeader.substring(7);
			userName = jwtTokenUtil.extractUsername(token);
		}

		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = customUserDetailsService.loadUserByUsername(userName);

			filterToken(httpServletRequest, token, userName, userDetails);
		}

		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}

	private void filterToken(HttpServletRequest httpServletRequest, String token, String userName,
			UserDetails userDetails) {
		if (jwtTokenUtil.validateToken(token, userDetails)) {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					userName, null, userDetails.getAuthorities());
			usernamePasswordAuthenticationToken
					.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
	}

}
