package com.laborstatistics.document;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chartCollection")
public class ChartDB {

	@Id
	private int chartId;
	private String type;
	private String title;
	private String xAxis;
	private String yAxis;
	private List<SeriesId> seriesId;
	
	public ChartDB() {
		this.seriesId = new ArrayList<>();
	}
	
	
	public ChartDB(int chartId, String type, String title, String xAxis, String yAxis, List<SeriesId> seriesId) {
		super();
		this.chartId = chartId;
		this.type = type;
		this.title = title;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.seriesId = seriesId;
	}
	
	
	public int getChartId() {
		return chartId;
	}
	public void setChartId(int chartId) {
		this.chartId = chartId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getxAxis() {
		return xAxis;
	}
	public void setxAxis(String xAxis) {
		this.xAxis = xAxis;
	}
	public String getyAxis() {
		return yAxis;
	}
	public void setyAxis(String yAxis) {
		this.yAxis = yAxis;
	}
	public List<SeriesId> getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(List<SeriesId> seriesId) {
		this.seriesId = seriesId;
	}
	
	
	
}
