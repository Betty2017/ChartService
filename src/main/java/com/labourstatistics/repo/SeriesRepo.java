package com.labourstatistics.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.labourstatistics.model.Series;

public interface SeriesRepo extends MongoRepository<Series, Integer> {

}
