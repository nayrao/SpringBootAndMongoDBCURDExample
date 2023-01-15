package com.example;

import static org.mockito.ArgumentMatchers.anyList;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.example.dto.ProductRequest;
import com.example.repo.ProductRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class SpringBootMongoDbApplicationTests {
	
	@Container
	static MongoDBContainer container=new  MongoDBContainer("mongo:4.4.2");
	
	@Autowired
	private MockMvc mockMvc;
	
	//ObjectMapper class can be used to convert Java objects to and from JSON
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private ProductRepo productRepo;
	@DynamicPropertySource
   static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.data.mongo.uri", container::getReplicaSetUrl);
	}
	@Test
	void contextLoads() throws Exception {
		ProductRequest productRequest = getProductRequest();
		//Convert Java object productRequest to a JSON string
		String productValueAsString = objectMapper.writeValueAsString(productRequest);
		// It used to call the save method in product controller
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
				//In Springboot we are providing content in the JSON Format
				.contentType(MediaType.APPLICATION_JSON)
				.content(productValueAsString))
				.andExpect(status().isCreated());
		Assertions.assertEquals(1, productRepo.findAll().size());
		
	}
	private ProductRequest getProductRequest() {
		
		return 	ProductRequest.builder()
			.name("Iphone")
			.description("120gb with 100pxl")
			.price(BigDecimal.valueOf(1234))
			.build();
			
		}
	
		/*
		 * @Test void getAllProducts() { getAllProductsFromRequest();
		 * mockMvc.perform(MockMvcRequestBuilders.get("/api/product") .contentType(null)
		 * .cont
		 * 
		 * )
		 * 
		 * } private List<ProductRequest> getAllProductsFromRequest() { ProductRequest
		 * p1=new ProductRequest("name", "description", BigDecimal.valueOf(1234));
		 * ProductRequest p2=new ProductRequest("name", "description",
		 * BigDecimal.valueOf(1234)); List al=new ArrayList<>(); al.add(p1);al.add(p2);
		 * return al; // TODO Auto-generated method stub
		 * 
		 * }
		 */
	
	
	

}
