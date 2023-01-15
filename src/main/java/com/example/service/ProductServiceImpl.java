package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ProductRequest;
import com.example.dto.ProductResponse;
import com.example.entity.Product;
import com.example.repo.ProductRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public String saveProduct(ProductRequest productRequest) {
		
		log.info("Inside ProductServiceImpl saveProduct()...");
		Product product=Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice()).build();
		
	   productRepo.save(product);
		log.info("Product is saved "+product.getId());		
		return "record saved ";
	}

	@Override
	public List<ProductResponse> getProducts() {
		log.info("Inside ProductServiceImpl getProducts()...");
		List<Product> products = productRepo.findAll();
		
		// we are mapping Product class to ProductResponse object
		//Beacuse we are not exposing our entity details to outside world
				List<ProductResponse> productResponses = products.stream()
				    .map(p -> new ProductResponse(p.getId(), p.getName(), p.getDescription(), p.getPrice()))
				    .collect(Collectors.toList());


		return productResponses;
	}

	@Override
	public Product updateProduct(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
