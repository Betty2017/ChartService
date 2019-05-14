package com.laborstatistics.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laborstatistics.document.ChartDB;
import com.laborstatistics.document.SeriesId;
import com.laborstatistics.model.LaborStatisticsResponse;
import com.laborstatistics.model.SeriesIdRequest;
import com.laborstatistics.service.LaborStatisticsService;
import com.labourstatistics.model.FinalResponse;


@RestController
@RequestMapping(value = "/public/bl/")
public class LabourStatisticsController {
	

	@Autowired
	LaborStatisticsService labourStatistics;
	
//	@Autowired
//	FinalResponse finalResponse;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
		
	@RequestMapping(value = "/multipleSeries/chartid", method = RequestMethod.POST)
	public FinalResponse getFinalResponse(@RequestBody int idFromUSer) throws JsonParseException, JsonMappingException, IOException, JSONException{
		
		SeriesIdRequest seriesIdRequest = new SeriesIdRequest();
		ChartDB chartdb = mongoTemplate.findById(idFromUSer, ChartDB.class);
		
		List<SeriesId> seriesIds = chartdb.getSeriesId();
		List<String> sIds = new ArrayList<>();
		
		for(int i =0 ; i< seriesIds.size(); i++)
		{
			SeriesId st = seriesIds.get(i);
			sIds.add(st.getSeriesId());
		}
		
		seriesIdRequest.setSeriesid(sIds);
		
		//seriesIdRequest.setSeriesid(Arrays.asList(seriesDB.getSeriesId()));
		ObjectMapper objectMapper = new ObjectMapper();
		String response = labourStatistics.viewAccountDetailBybyAccountId(seriesIdRequest);
		
		List<String> values = new ArrayList<>();
		for(int i=0; i<seriesIds.size(); i++)
		{
		
		JSONObject obj=new JSONObject(response.toString()); 
		JSONObject obj1=obj.getJSONObject("Results");
		JSONArray obj2=obj1.getJSONArray("series");
		JSONObject obj3=obj2.getJSONObject(i);
		JSONArray obj4=obj3.getJSONArray("data");
		JSONObject obj5=obj4.getJSONObject(i);
		
		String str = (obj5.get("value").toString());
		values.add(i, str);
		
		}
	   
	    
	    LaborStatisticsResponse labourStatisticsResponse = objectMapper.readValue(response, LaborStatisticsResponse.class);
		
		FinalResponse finalResponse = new FinalResponse(chartdb,labourStatisticsResponse);
		
		return finalResponse;
	
	 
	}
	
	
}
