package com.bestfilms.entities;

import javax.persistence.*;

@Entity
@Table(name="film")

public class Film {

    @Id @GeneratedValue
    @Column(name = "filmId")
    private Long filmId;

    @Column(name = "title")
    private String title;

    @Column(name = "released")
    private String released;

    @Column(name = "genre")
    private String genre;

    @Column(name = "director")
    private String director;

    @Column(name = "actors")
    private String actors;

    @Column(name = "images")
    private String images;

    @Column(name = "awards")
    private String awards;

    @Column(name = "plot")
    private String plot;

    public Film() {
    }

    public Film(Long filmId, String title, String released, String genre, String director, String actors, String images, String awards, String plot) {
        this.filmId = filmId;
        this.title = title;
        this.released = released;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.images = images;
        this.awards = awards;
        this.plot = plot;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
