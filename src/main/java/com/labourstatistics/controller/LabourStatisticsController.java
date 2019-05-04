package com.labourstatistics.controller;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.labourstatistics.document.Chart;
import com.labourstatistics.document.SeriesDB;
import com.labourstatistics.model.LabourStatisticsResponse;
import com.labourstatistics.model.SeriesIdRequest;
import com.labourstatistics.service.LabourStatisticsService;

@RestController
@RequestMapping(value = "/public/labourStatistics/")
public class LabourStatisticsController {

	@Autowired
	LabourStatisticsService labourStatistics;
	@Autowired
	MongoTemplate mongoTemplate;
	
	public void StoreData(){
		Chart chart = new Chart();
		SeriesDB series = new SeriesDB();
		chart.setId(2);
		chart.setTitle("SingleSeries");
		chart.setType("Pie Chart");
		chart.setxAxis("Month");
		chart.setyAxis("Frequence");
		mongoTemplate.save(chart);
		
		series.setSeriesId("LAUCN040010000000005");
		series.setId(2);
		mongoTemplate.save(series);
		
	}
	
	
	@RequestMapping(value = "/multipleSeries", method = RequestMethod.POST)
	public LabourStatisticsResponse labourStatisticsMultipleSeries(@RequestBody int idFromUSer) throws JsonParseException, JsonMappingException, IOException{
		SeriesIdRequest seriesIdRequest = new SeriesIdRequest();
		SeriesDB seriesDB = mongoTemplate.findById(idFromUSer, SeriesDB.class);
		seriesIdRequest.setSeriesid(Arrays.asList(seriesDB.getSeriesId()));
		ObjectMapper objectMapper = new ObjectMapper();
		String response = labourStatistics.viewAccountDetailBybyAccountId(seriesIdRequest);
		LabourStatisticsResponse labourStatisticsResponse = objectMapper.readValue(response, LabourStatisticsResponse.class);
		return labourStatisticsResponse;
	}
	
	
}
