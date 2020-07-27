package com.jamal.spring.soap.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.jamal.spring.soap.api.loaneligibility.Acknowledgement;
import com.jamal.spring.soap.api.loaneligibility.CustomerRequest;

@Service
public class SoapClinet {

	@Autowired
	private Jaxb2Marshaller marshaller;

	private WebServiceTemplate template;
	
	  public Jaxb2Marshaller marshaller() {
	    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	    // this package must match the package in the <generatePackage> specified in
	    // pom.xml
	    marshaller.setContextPath("com.jamal.spring.soap.api.loaneligibility");
	    return marshaller;
	  }

	public Acknowledgement getLoanStatus(CustomerRequest request) {
		template = new WebServiceTemplate(marshaller);
		//http://localhost:8080/ws/testEligibility.wsdl
		template.setDefaultUri("http://localhost:8080/ws/testEligibility.wsdl");
		template.setMarshaller(marshaller);
		Acknowledgement acknowledgement = (Acknowledgement)template.marshalSendAndReceive(request);
		/*Acknowledgement acknowledgement = (Acknowledgement) template.marshalSendAndReceive("http://localhost:8080/ws",
				request);*/
		return acknowledgement;
	}

}
