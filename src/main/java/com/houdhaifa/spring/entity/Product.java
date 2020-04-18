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
 * calss Product
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {
	
	/**
	 * the ID of PRODUCT Table
	 */
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String name;
	private Integer quantity;
	private Double price;
	

}
