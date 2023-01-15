package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ProductRequest;
import com.example.dto.ProductResponse;
import com.example.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/product")
@RestController
@Slf4j
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveContact(@RequestBody ProductRequest productRequest){
		
		log.info("Inside Product Controller saveContact()");
		String product = productService.saveProduct(productRequest);
		
		return new ResponseEntity<String>(product, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/allProducts")
	public ResponseEntity<List<ProductResponse>> getAllProducts(){
		log.info("Inside Product Controller getAllProducts()");
		List<ProductResponse> products = productService.getProducts();
		return new ResponseEntity<List<ProductResponse>>(products, HttpStatus.OK);
		
		
	}

}
