package com.parth.movieapi.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.parth.movieapi.models.documents.MovieDocuments;
import com.parth.movieapi.models.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
/**
 * Movie
 */
@Service("Movie")
public class Movie {

    @Autowired
    private MovieRepository movieRepository;
    
    public List<Object> findMovie(String prefix,int limit){
        List<Object> response =new LinkedList<>();
        MovieDocuments movieDoc=new MovieDocuments();
        movieDoc.setName(prefix);
        Pageable limitRequest=PageRequest.of(0, 1);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", match -> match.startsWith());
        Example<MovieDocuments> example= Example.of(movieDoc, matcher);
        while (true) {
            Page<MovieDocuments> page=movieRepository.findAll(example, limitRequest);
            int number = page.getNumber();
            int numberOfElements = page.getNumberOfElements();
            int size = page.getSize();
            long totalElements = page.getTotalElements();
            int totalPages = page.getTotalPages();
            System.out.printf("page info - page number %s, numberOfElements: %s, size: %s, "
                            + "totalElements: %s, totalPages: %s%n",
                    number, numberOfElements, size, totalElements, totalPages);
            List<MovieDocuments> movieList = page.getContent();

            movieList.forEach(action->{
                response.add(action.getName());
            });

            if (!page.hasNext()) {
                break;
            }
            limitRequest = page.nextPageable();
        }
        return response;
    }

    public Map<String, Object> createMovie(Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
        MovieDocuments movieDoc=new MovieDocuments(ObjectId.get(),(String) request.get("movie"));
        movieRepository.save(movieDoc);
        response.put("movie", movieDoc.getName());
        response.put("id", movieDoc.get_id().toString());
        return response;
    }
}