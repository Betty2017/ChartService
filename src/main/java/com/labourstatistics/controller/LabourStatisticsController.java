package com.labourstatistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.labourstatistics.model.LabourStatisticsResponse;
import com.labourstatistics.model.SeriesIdRequest;
import com.labourstatistics.service.LabourStatisticsService;

@RestController
@RequestMapping(value = "/public/labourStatistics/")
public class LabourStatisticsController {

	@Autowired
	LabourStatisticsService labourStatistics;
	
	@RequestMapping(value = "/multipleSeries", method = RequestMethod.POST)
	public String labourStatisticsMultipleSeries(@RequestBody SeriesIdRequest seriesIdRequest){
		String response = labourStatistics.viewAccountDetailBybyAccountId(seriesIdRequest);
		return response;
	}
	
	
}
