package com.example.android.popularmovies.model;

import java.util.Date;

/**
 * Created by seridan on 06/03/2018.
 */

public class Movie {

    private int id;
    private String originalTitle;
    private String overview;
    private String backDropPath;
    private String releaseDate;
    private double vote_average;

    public Movie() {
    }

    public Movie(int id, String originalTitle, String overview, String backDropPath, String releaseDate,
    double vote_average){
        this.id = id;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.backDropPath = backDropPath;
        this.releaseDate = releaseDate;
        this.vote_average = vote_average;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBackDropPath() {
        return backDropPath;
    }

    public void setBackDropPath(String backDropPath) {
        this.backDropPath = backDropPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }
}
