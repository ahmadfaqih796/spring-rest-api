package com.latihan.demoapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latihan.demoapi.models.entities.Product;
import com.latihan.demoapi.models.repository.ProductRepo;

import jakarta.transaction.TransactionScoped;

@Service
@TransactionScoped
public class ProductService {

   @Autowired
   private ProductRepo productRepo;

   @SuppressWarnings("null")
   public Product create(Product product) {
      return productRepo.save(product);
   }

   @SuppressWarnings("null")
   public Product findOne(Long id) {
      return productRepo.findById(id).get();
   }

   public Iterable<Product> findAll() {
      return productRepo.findAll();
   }

   @SuppressWarnings("null")
   public void removeOne(Long id) {
      productRepo.deleteById(id);
   }

   public List<Product> findByName(String name) {
      return productRepo.findByNameContains(name);
   }
}
