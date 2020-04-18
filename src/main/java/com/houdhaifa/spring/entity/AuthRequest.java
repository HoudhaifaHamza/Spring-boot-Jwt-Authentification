/**
 * 
 */
package com.houdhaifa.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Houdhaifa Hamza
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
	
	private String email;
	private String password;

}
