package com.jamal.spring.soap.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jamal.spring.soap.api.client.SoapClinet;
import com.jamal.spring.soap.api.loaneligibility.Acknowledgement;
import com.jamal.spring.soap.api.loaneligibility.CustomerRequest;

@SpringBootApplication
@RestController
public class SpringBootSopaWsClientApplication {
	
	@Autowired
	private SoapClinet clinet;
	
	@PostMapping("/getLoanStatus")
	public Acknowledgement invokeSoapClientToGetLoanStatus(@RequestBody CustomerRequest request) {
		return clinet.getLoanStatus(request);
	}

	@GetMapping("/getLoan")
	public Acknowledgement invokeSoapClientToGetLoanStatus() {
		CustomerRequest customerRequest=new CustomerRequest();
		customerRequest.setCustomerName("Jamla");
		customerRequest.setAge(25);
		customerRequest.setCibilScore(600);
		customerRequest.setYearlyIncome(500000);
		return clinet.getLoanStatus(customerRequest);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSopaWsClientApplication.class, args);
	}

}
