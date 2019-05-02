package com.labourstatistics.model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "seriesID",
    "data"
})
public class Series {

    @JsonProperty("seriesID")
    private String seriesID;
    @JsonProperty("data")
    private List<Datum> data = null;

    @JsonProperty("seriesID")
    public String getSeriesID() {
        return seriesID;
    }

    @JsonProperty("seriesID")
    public void setSeriesID(String seriesID) {
        this.seriesID = seriesID;
    }

    @JsonProperty("data")
    public List<Datum> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Datum> data) {
        this.data = data;
    }

}
