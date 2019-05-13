package com.labourstatistics.model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "responseTime",
    "message",
    "Results"
})
public class Example {

    @JsonProperty("status")
    private String status;
    @JsonProperty("responseTime")
    private Long responseTime;
    @JsonProperty("message")
    private List<String> message = null;
    @JsonProperty("Results")
    private Results results;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("responseTime")
    public Long getResponseTime() {
        return responseTime;
    }

    @JsonProperty("responseTime")
    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }

    @JsonProperty("message")
    public List<String> getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(List<String> message) {
        this.message = message;
    }

    @JsonProperty("Results")
    public Results getResults() {
        return results;
    }

    @JsonProperty("Results")
    public void setResults(Results results) {
        this.results = results;
    }

}
