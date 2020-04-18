/**
 * 
 */
package com.houdhaifa.spring.service;

import java.util.List;

import com.houdhaifa.spring.entity.Product;

/**
 * @author Houdhaifa Hamza
 *
 */
public interface ProductService {
	
	/**
	 * 
	 * @param product
	 * @return Product
	 * method to save one product
	 */
	public Product saveProduct(Product product);
	
	/**
	 * 
	 * @param products
	 * @return List of products
	 * methot to save a List of products
	 */
	public List<Product> saveProducts(List<Product> products);
	
	/**
	 * 
	 * @return List of products
	 * method to fin all products
	 */
	public List<Product> getProducts();
	
	/**
	 * 
	 * @param id
	 * @return Product
	 * method to find product by Id
	 */
	public Product getProductById(Integer id);
	
	/**
	 * 
	 * @param name
	 * @return Product
	 * method to find product by name
	 */
	public Product getProductByName(String name);
	
	/**
	 * 
	 * @param id
	 * @return
	 * method to delete a product 
	 */
	public String deleteProduct(Integer id);
	
	
	/**
	 * 
	 * @param product
	 * @return Product
	 * method to update a product
	 */
	public Product updateProduct(Product product);

}
