package com.rest.demo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.rest.demo.config.User;

public class ApiServices {
	private final RestTemplate restTemplate;

	public ApiServices(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public User getDataFromApi() {
		String apiUrl = "https://api.example.com/data"; // Replace with actual API URL
		User response = restTemplate.getForObject(apiUrl, User.class);
		// restTemplate.exchange(apiUrl, null, null, null);
		return response;
	}

	public User getDataFromApi1() {
		String apiUrl = "https://api.example.com/data"; // Replace with actual API URL

		// Create headers if needed
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer YOUR_ACCESS_TOKEN");
		// Add other headers as needed

		// Create a request entity with headers
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);

		// Use the exchange method to make the request
		ResponseEntity<User> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, // Replace with the
																							// appropriate HTTP method
				requestEntity, User.class);

		// Get the response body from the ResponseEntity
		User response = responseEntity.getBody();
		return response;
	}
}
