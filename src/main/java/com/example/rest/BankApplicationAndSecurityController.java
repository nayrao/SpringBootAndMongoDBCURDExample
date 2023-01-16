package com.example.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankApplicationAndSecurityController {
	
	@GetMapping("/home")
	public String home() {
		String msg="Welcome to ICICI Bank Home Page...";
		return msg;
	}
	
	@GetMapping("/balance")
	public String getBalance() {
		String msg="Your account balance is $4500.00";
		return msg;
	}
	@GetMapping("/statement")
	public String getStmt() {
		String msg="Your account statement will be upto date..";
		return msg;
	}
	
	@GetMapping("/loan")
	public String getLoan() {
		String msg="your loan amount due is::9877";
		return msg;
	}
	
	@GetMapping("/home")
	public String contact() {
		String msg="Thank you for contact us we will respond shortly..";
		return msg;
	}

}
