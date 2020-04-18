/**
 * 
 */
package com.houdhaifa.spring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.houdhaifa.service.ProductService;
import com.houdhaifa.spring.entity.Product;
import com.houdhaifa.spring.repository.ProductRepository;

/**
 * @author Houdhaifa Hamza
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> saveProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public String deleteProduct(Integer id) {
			   productRepository.deleteById(id);
		return "product removed  "+id;
	}

	@Override
	public Product updateProduct(Product product) {
		Product oldProduct = productRepository.findById(product.getId()).orElse(null) ;
		oldProduct.setName(product.getName());
		oldProduct.setQuantity(product.getQuantity());
		oldProduct.setPrice(product.getPrice());
		return productRepository.save(oldProduct);
	}

}
