package com.latihan.demoapi.models.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.latihan.demoapi.models.entities.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
   // Buat fitur search
   List<Product> findByNameContains(String name);
}
