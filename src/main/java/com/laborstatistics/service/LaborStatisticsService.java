package com.laborstatistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laborstatistics.model.LaborStatisticsResponse;
import com.laborstatistics.model.SeriesIdRequest;

@Service
public class LaborStatisticsService {

	@Autowired
	private RestTemplate restTemplate;

	private ObjectMapper objectMapper;

	public String viewAccountDetailBybyAccountId(SeriesIdRequest seriesIdRequest) {
		LaborStatisticsResponse labourStatisticsResponse = new LaborStatisticsResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		String accountByIdURL = "https://api.bls.gov/publicAPI/v2/timeseries/data/";
		HttpEntity<?> requestEntity = new HttpEntity<>(seriesIdRequest, headers);
		ResponseEntity<String> labourStatisticsResponseEntity = null;
		String stringResponse = null;
		try {
			labourStatisticsResponseEntity = restTemplate.exchange(accountByIdURL, HttpMethod.POST, requestEntity, String.class);
			stringResponse = labourStatisticsResponseEntity.getBody();
			labourStatisticsResponse = objectMapper.readValue(stringResponse, LaborStatisticsResponse.class);
		} catch (Exception e) {
			System.out.println("Exception occured during the call  " + e.getMessage());
		}
		return stringResponse;
	}
}
