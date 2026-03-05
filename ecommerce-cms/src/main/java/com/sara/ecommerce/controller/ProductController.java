package com.sara.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.sara.ecommerce.model.Product;
import com.sara.ecommerce.repository.ProductRepository;

@RestController // return json
@RequestMapping("/products") // define url
public class ProductController {
	
	private final ProductRepository productRepository;

//	constructor injection
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
//	get /products
	@GetMapping
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
//	post /products
	@PostMapping
	public Product createProduct(@RequestBody Product product) { // RequestBody = take json and turn it into a Product object
		return productRepository.save(product);
	}
	
//	get /products/{id}
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productRepository.findById(id).orElse(null);
//		SELECT * FROM product WHERE id = ?
	}
	
	

}
