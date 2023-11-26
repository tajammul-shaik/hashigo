package com.crud.hashigo.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.hashigo.exceptions.ResourceNotFoundException;
import com.crud.hashigo.models.Product;
import com.crud.hashigo.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class ProductControllers {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@GetMapping("/products")
	public List<Product> getAllProduct() {
		return productServiceImpl.getAllProduct();
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId)
			throws ResourceNotFoundException {
		return productServiceImpl.getProductById(productId);
	}

	@PostMapping("/products")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productServiceImpl.createProduct(product);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
			@Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
		return productServiceImpl.updateProduct(productId, productDetails);
	}

	@DeleteMapping("/products/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId)
			throws ResourceNotFoundException {
		return productServiceImpl.deleteProduct(productId);
	}
}
