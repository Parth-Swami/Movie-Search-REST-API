package com.parth.movieapi.models.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.parth.movieapi.models.Movie;

/**
 * MovieRepository
 */
@Repository
public interface MovieRepository extends MongoRepository<Movie,Integer> {

    
}