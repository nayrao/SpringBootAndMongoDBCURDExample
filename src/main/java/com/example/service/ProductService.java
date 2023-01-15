package com.example.service;

import java.util.List;

import com.example.dto.ProductRequest;
import com.example.dto.ProductResponse;
import com.example.entity.Product;

public interface ProductService {
	
	public String saveProduct(ProductRequest productRequest);
	
	public List<ProductResponse> getProducts();
	
	public Product updateProduct(Integer id);
	
	public String deleteProduct(Integer id);

}
