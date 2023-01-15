package com.example.repo;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Product;
@Repository
public interface ProductRepo extends MongoRepository<Product, Serializable>{

}
