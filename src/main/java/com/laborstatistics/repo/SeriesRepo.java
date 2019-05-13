package com.laborstatistics.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.laborstatistics.model.Series;

public interface SeriesRepo extends MongoRepository<Series, Integer> {

}
