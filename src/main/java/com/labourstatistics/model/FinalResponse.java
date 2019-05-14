
package com.labourstatistics.model;

import com.laborstatistics.document.ChartDB;
import com.laborstatistics.model.LaborStatisticsResponse;

import javafx.scene.chart.Chart;

public class FinalResponse {

	public ChartDB chartdb;
	public LaborStatisticsResponse labourResponse;

	public FinalResponse(ChartDB chartdb, LaborStatisticsResponse labourResponse) {
        this.chartdb=chartdb;
        this.labourResponse=labourResponse;
        
        
	}

	public ChartDB getChart() {
		return chartdb;
	}

	public void setChart(ChartDB chartdb) {
		this.chartdb = chartdb;
	}

	public LaborStatisticsResponse getLabourResponse() {
		return labourResponse;
	}

	public void setLabourResponse(LaborStatisticsResponse labourResponse) {
		this.labourResponse = labourResponse;
	}

}
