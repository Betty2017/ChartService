package com.laborstatistics.document;

public class SeriesId {
	
	private String lable;
	private String seriesId;
	
	public SeriesId() {
		
	}
	
	public SeriesId(String lable, String seriesId) {
		super();
		this.lable = lable;
		this.seriesId = seriesId;
	}
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public String getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}
	
	
	

}
