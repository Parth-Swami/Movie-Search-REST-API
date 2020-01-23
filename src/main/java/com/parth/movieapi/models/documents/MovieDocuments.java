package com.parth.movieapi.models.documents;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Movie
 */
@Document(collection = "movies")
public class MovieDocuments {

    @Id
    private ObjectId _id;
    private String name;

    public MovieDocuments(){}

    public MovieDocuments(ObjectId _id,String name){
        this._id=_id;
        this.name=name;
    }

    public ObjectId get_id() {
        return this._id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }  

}