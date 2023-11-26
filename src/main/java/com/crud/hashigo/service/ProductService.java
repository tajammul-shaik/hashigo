package com.crud.hashigo.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.crud.hashigo.exceptions.ResourceNotFoundException;
import com.crud.hashigo.models.Product;

public interface ProductService {

	public List<Product> getAllProduct();

	public ResponseEntity<Product> getProductById(Long productId) throws ResourceNotFoundException;

	public Product createProduct(Product product);

	public ResponseEntity<Product> updateProduct(Long productId, Product productDetails) throws ResourceNotFoundException;

	public Map<String, Boolean> deleteProduct(Long productId) throws ResourceNotFoundException;
}
