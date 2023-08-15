package com.rest.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Service
public class ApiServicesForGson {
	private final RestTemplate restTemplate;
	private final Gson gson;

	@Autowired
	public ApiServicesForGson(RestTemplate restTemplate, Gson gson) {
		this.restTemplate = restTemplate;
		this.gson = gson;
	}

	public User getDataFromApi() {
		String apiUrl = "https://api.example.com/data"; // Replace with actual API URL

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, null, String.class);

		String responseBody = responseEntity.getBody();
		User response = gson.fromJson(responseBody, User.class);
		return response;
	}
}
