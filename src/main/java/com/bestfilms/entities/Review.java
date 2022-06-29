package com.bestfilms.entities;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id @GeneratedValue
    private Long reviewId;
    private String review;
    private Long userId;
    private Long filmId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "filmId", referencedColumnName = "filmId", insertable = false, updatable = false)
    private Film film;

    public Review() { }

    public Review(Long reviewId, String review, Long userId, Long filmId, Film film) {
        this.reviewId = reviewId;
        this.review = review;
        this.userId = userId;
        this.filmId = filmId;
        this.film = film;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
