package com.laborstatistics.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
/*@JsonPropertyOrder({
    "status",
    "responseTime",
    "message",
    "Results"
})*/
public class LaborStatisticsResponse {

    @JsonProperty("status")
    private String status;
    @JsonProperty("responseTime")
    private int responseTime;
    @JsonProperty("message")
    private List<String> message = null;
    @JsonProperty("Results")
    private Results results;
    
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(int responseTime) {
		this.responseTime = responseTime;
	}
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> message) {
		this.message = message;
	}
	public Results getResults() {
		return results;
	}
	public void setResults(Results results) {
		this.results = results;
	}

    
}
