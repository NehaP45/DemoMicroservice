package com.example.demoMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class demoController {
	@Autowired
	private RestTemplate rs;
	
	@Autowired
	private WebClient.Builder ws;
	
	@GetMapping("/Hi")  
	public String Hello()  
	{  
		
		String ss="Welcome to  Microservice 2";
	return ss;  
	} 
	//calling hello method of student ms from demo ms
	@GetMapping("/studentHelloClient")
	public String StudentHelloMethod(){
		//this method reaches usto welcome message of student microservice
		String uri="http://localhost:8082/";
		RestTemplate rs=new RestTemplate();
		String ss=rs.getForObject(uri, String.class);
		return ss;
		
		
	}
	//calling /student method of student microservice
	@GetMapping("/studentInfoClient")
	public String  StudentinfoClient() {
		String uri="http://localhost:8082/student";
		RestTemplate rs=new RestTemplate();
		String ss=rs.getForObject(uri, String.class);
		
		return ss;
		
	}
	//method used to call rest api via web client
	@GetMapping("/studentWebClient")
	public String  StudentWebClient() {
		//WebClient.Builder=new WebClient();
		String val = ws.build().get().uri("http://localhost:8082/student").retrieve().bodyToMono(String.class).block();
		return val;
	}
	

}
