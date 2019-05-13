package com.laborstatistics.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.laborstatistics.document.ChartDB;
import com.laborstatistics.document.SeriesId;
import com.laborstatistics.repo.ChartDBRepo;

@Component 
public class DbSeeder implements CommandLineRunner {
	
	    private ChartDBRepo chartRepo;

	    public DbSeeder(ChartDBRepo chartRepo) {
	        this.chartRepo = chartRepo;
	    }

	    @Override
	    public void run(String... strings) throws Exception {
	        ChartDB chart1 = new ChartDB(
	        		1,
	                "Bar Chart",
	                "Employment By Industry",
	                "Location",
	                "None",
	                
	                
	                Arrays.asList(
	                        new SeriesId("Mining, logging and Construction","SMU11479001500000001"),
	                        new SeriesId("Manufacturing ", "SMU11479003000000001"),
	                        new SeriesId("Wholesale trade", "SMU11479004100000001"),
	                        new SeriesId("Retail trade", "SMU11479004200000001"),
	                        new SeriesId("Transportation, warehousing, and  utilities", "SMU11479004300000001"),
	                        new SeriesId("Information", "SMU11479005000000001")
	                       
	                      
	                )
	        );

	        ChartDB chart2 = new ChartDB(
	        		2,
	                "Bar",
	                "Bar",
	                "Bar",
	                "Bar",
	                
	                
	                Arrays.asList(
	                        new SeriesId("hfhds","SMU11479001500000001"),
	                        new SeriesId("fffff", "SMU11479003000000001"),
	                        new SeriesId("fffff", "SMU11479004100000001"),
	                        new SeriesId("fffff", "SMU11479004200000001"),
	                        new SeriesId("fffff", "SMU11479004300000001")
	                      
	                )
	        );


	        // drop all hotels
	        this.chartRepo.deleteAll();

	        //add our hotels to the database
	        List<ChartDB> chartdbs1 = Arrays.asList(chart1);
	        this.chartRepo.save(chartdbs1);
	    
	    List<ChartDB> chartdbs2 = Arrays.asList(chart2);
        this.chartRepo.save(chartdbs2);
    }
    
}
