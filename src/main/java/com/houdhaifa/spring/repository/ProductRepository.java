/**
 * 
 */
package com.houdhaifa.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houdhaifa.spring.entity.Product;

/**
 * @author Tasnim Hz
 *
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);

}
