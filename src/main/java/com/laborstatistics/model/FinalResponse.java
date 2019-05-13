package com.laborstatistics.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.laborstatistics.document.ChartDB;

public class FinalResponse {
	@JsonProperty("chart")
	private ChartDB chartDb;
	
	@JsonProperty("laborResponse")
	private LaborStatisticsResponse laborResponse;

	public FinalResponse() {
		
	}
	
	public FinalResponse(ChartDB chartDb, LaborStatisticsResponse laborResponse) {
		super();
		this.chartDb = chartDb;
		this.laborResponse = laborResponse;
	}

	public ChartDB getChartDb() {
		return chartDb;
	}

	public void setChartDb(ChartDB chartDb) {
		this.chartDb = chartDb;
	}

	public LaborStatisticsResponse getLaborResponse() {
		return laborResponse;
	}

	public void setLaborResponse(LaborStatisticsResponse laborResponse) {
		this.laborResponse = laborResponse;
	}
	
	

}
