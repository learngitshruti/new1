package com.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class controlle  {

	@Autowired
	private RestTemplate resttemplate;
	
	@RequestMapping(value="/hey")
	public String getimage() {
		HttpHeaders header= new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON) );
		HttpEntity<Integer> entity = new HttpEntity<>(header);
		ResponseEntity ent= resttemplate.getForEntity("https://www.goggle.com/", String.class);
		String body= (String) ent.getBody();
		System.out.println(body);
		
		return resttemplate.exchange("https://www.google.com/", HttpMethod.GET, entity, String.class).getBody();		
		
	}
	
	@RequestMapping(value="/hi")
	public String sayhi() {
		System.out.println("hi");
		return "hello";
	}
	
	@GetMapping(value="/home")
	public String hi()
{     System.out.println("hhhh");
		return "me";
	
}
	
	

}
