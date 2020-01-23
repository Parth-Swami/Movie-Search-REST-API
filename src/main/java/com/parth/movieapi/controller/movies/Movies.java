package com.parth.movieapi.controller.movies;

import java.util.Map;
import javax.validation.Valid;
import com.parth.movieapi.models.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.*;
/**
 * movies
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/movies")
public class Movies {
   
    @Autowired
    Movie movie;

    @RequestMapping(value = "/search/{prefix}/{limit}", method = RequestMethod.GET)
    public List<Object> getMovies(@PathVariable String prefix,@PathVariable Integer limit) {

         return movie.findMovie(prefix, limit);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, Object> createMovie(@Valid @RequestBody Map<String, Object> request) {
        return movie.createMovie(request);
    }
}