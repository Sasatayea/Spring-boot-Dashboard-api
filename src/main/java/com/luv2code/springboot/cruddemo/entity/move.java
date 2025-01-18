package com.luv2code.springboot.cruddemo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "moves")
public class move {

    private String Title;
    private String Year;
    private String Rated;
    private String Released;
    private String Runtime;
    private String Genre;
    private String Director;
    private String Writer;
    private String Actors;
    private String Plot;
    private String Language;
    private String Country;
    private String Awards;
    private String Poster;
    private String Metascore;
    private String imdbRating;
    private String imdbVotes;
    @Id
    private String imdbID;
    private String Type;
    private String DVD;
    private String BoxOffice;
    private String Production;
    private String Website;
    private String Response;

    // getters and setters

    @JsonProperty("Title")
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @JsonProperty("Year")
    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }
    @JsonProperty("Rated")
    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    @JsonProperty("Released")
    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }
    @JsonProperty("Runtime")
    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    @JsonProperty("Genre")
    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }
    @JsonProperty("Director")
    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }
    @JsonProperty("Writer")
    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }
    @JsonProperty("Actors")
    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }
    @JsonProperty("Plot")
    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    @JsonProperty("Language")
    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    @JsonProperty("Country")
    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    @JsonProperty("Awards")
    public String getAwards() {
        return Awards;
    }

    public void setAwards(String awards) {
        Awards = awards;
    }

    @JsonProperty("Poster")
    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    @JsonProperty("Metascore")
    public String getMetascore() {
        return Metascore;
    }

    public void setMetascore(String metascore) {
        Metascore = metascore;
    }
    @JsonProperty("imdbRating")
    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    @JsonProperty("imdbVotes")
    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }
    @JsonProperty("Type")
    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
    @JsonProperty("DVD")
    public String getDVD() {
        return DVD;
    }

    public void setDVD(String DVD) {
        this.DVD = DVD;
    }
    @JsonProperty("BoxOffice")
    public String getBoxOffice() {
        return BoxOffice;
    }
    public void setBoxOffice(String boxOffice) {
        BoxOffice = boxOffice;
    }
    @JsonProperty("Production")
    public String getProduction() {
        return Production;
    }

    public void setProduction(String production) {
        Production = production;
    }

    @JsonProperty("Website")
    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    @JsonProperty("Response")
    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

}
