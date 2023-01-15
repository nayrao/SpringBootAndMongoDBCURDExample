package com.example.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Document(collection ="product")
@Builder
public class Product {
	@Id
	private String id;
	private String name;
	private String description;
	private BigDecimal price;

}
