package com.crud.hashigo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.hashigo.exceptions.ResourceNotFoundException;
import com.crud.hashigo.models.Product;
import com.crud.hashigo.repository.HashigoProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private HashigoProductRepository hashigoProductRepository;

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return hashigoProductRepository.findAll();
	}

	@Override
	public ResponseEntity<Product> getProductById(Long productId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Product product = hashigoProductRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
		return ResponseEntity.ok().body(product);
	}

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return hashigoProductRepository.save(product);
	}

	@Override
	public ResponseEntity<Product> updateProduct(Long productId, Product productDetails)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Product product = hashigoProductRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

		product.setProductName(productDetails.getProductName());
		final Product updateProduct = hashigoProductRepository.save(product);
		return ResponseEntity.ok(updateProduct);
	}

	@Override
	public Map<String, Boolean> deleteProduct(Long productId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Product product = hashigoProductRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

		hashigoProductRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
