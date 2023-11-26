package com.crud.hashigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.hashigo.models.Product;

public interface HashigoProductRepository extends JpaRepository<Product, Long> {

}
