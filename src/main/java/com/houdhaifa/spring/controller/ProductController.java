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

import com.houdhaifa.service.ProductService;
import com.houdhaifa.spring.entity.Product;

/**
 * @author Houdhaifa Hamza
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/addProduct")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@PostMapping("/addProducts")
	public List<Product> saveProducts(@RequestBody List<Product> product) {
		return productService.saveProducts(product);
	}

	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return productService.getProducts();
	}

	@GetMapping("/productById/{id}")
	public Product findProductById(@PathVariable Integer id) {
		return productService.getProductById(id);
	}

	@GetMapping("/product/{name}")
	public Product findProductByName(@PathVariable String name) {
		return productService.getProductByName(name);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		return productService.deleteProduct(id);
	}

	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

}
