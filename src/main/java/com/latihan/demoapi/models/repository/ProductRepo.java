package com.latihan.demoapi.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.latihan.demoapi.models.entities.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {

}
