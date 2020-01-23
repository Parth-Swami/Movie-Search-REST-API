package com.parth.movieapi.controller.movies;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import com.parth.movieapi.models.Movie;
import com.parth.movieapi.models.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * movies
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/movies")
public class Movies {
    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = "/search/{prefix}/{limit}", method = RequestMethod.GET)
    public ResponseEntity<String> getMovies(@PathVariable String prefix,@PathVariable Integer limit) {
        System.out.println(limit);
        return new ResponseEntity<String>("Hello", HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, Object> createMovie(@Valid @RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
        Movie movie=new Movie(ObjectId.get(),(String) request.get("movie"));
        movieRepository.save(movie);
        response.put("movie", movie.getName());
        response.put("id", movie.get_id().toString());
        return response;
    }
}