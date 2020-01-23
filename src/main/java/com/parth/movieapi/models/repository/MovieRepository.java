package com.parth.movieapi.models.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.parth.movieapi.models.documents.MovieDocuments;

/**
 * MovieRepository
 */
@Repository
public interface MovieRepository extends MongoRepository<MovieDocuments,ObjectId> {

    
}