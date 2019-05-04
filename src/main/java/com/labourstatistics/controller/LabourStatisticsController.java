package com.labourstatistics.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.labourstatistics.model.LabourStatisticsResponse;
import com.labourstatistics.model.SeriesIdRequest;
import com.labourstatistics.service.LabourStatisticsService;

@RestController
@RequestMapping(value = "/public/labourStatistics/")
public class LabourStatisticsController {

	@Autowired
	LabourStatisticsService labourStatistics;
	
	@RequestMapping(value = "/multipleSeries", method = RequestMethod.POST)
	public LabourStatisticsResponse labourStatisticsMultipleSeries(@RequestBody SeriesIdRequest seriesIdRequest) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		String response = labourStatistics.viewAccountDetailBybyAccountId(seriesIdRequest);
		LabourStatisticsResponse labourStatisticsResponse = objectMapper.readValue(response, LabourStatisticsResponse.class);
		return labourStatisticsResponse;
	}
	
	
}
