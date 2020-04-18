/**
 * 
 */
package com.houdhaifa.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Houdhaifa Hamza
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="USER")
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private String name;
	private String email;
	private String password;
	private String role;

}
