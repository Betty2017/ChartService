package com.laborstatistics.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.laborstatistics.document.ChartDB;


@Repository
public interface ChartDBRepo extends MongoRepository<ChartDB, Integer> {

	ChartDB findByChartId(int chartId);

}
