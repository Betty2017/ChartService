package com.labourstatistics.model;



import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "year",
    "period",
    "periodName",
    "latest",
    "value",
    "footnotes"
})
public class Datum {

    @JsonProperty("year")
    private String year;
    @JsonProperty("period")
    private String period;
    @JsonProperty("periodName")
    private String periodName;
    @JsonProperty("latest")
    private String latest;
    @JsonProperty("value")
    private String value;
    @JsonProperty("footnotes")
    private List<Footnote> footnotes = null;

    @JsonProperty("year")
    public String getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("period")
    public String getPeriod() {
        return period;
    }

    @JsonProperty("period")
    public void setPeriod(String period) {
        this.period = period;
    }

    @JsonProperty("periodName")
    public String getPeriodName() {
        return periodName;
    }

    @JsonProperty("periodName")
    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    @JsonProperty("latest")
    public String getLatest() {
        return latest;
    }

    @JsonProperty("latest")
    public void setLatest(String latest) {
        this.latest = latest;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("footnotes")
    public List<Footnote> getFootnotes() {
        return footnotes;
    }

    @JsonProperty("footnotes")
    public void setFootnotes(List<Footnote> footnotes) {
        this.footnotes = footnotes;
    }

}
