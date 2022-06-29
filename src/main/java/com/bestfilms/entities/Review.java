package com.bestfilms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    public Review(Long reviewId, String review, Long userId, Long filmId) {
        this.reviewId = reviewId;
        this.review = review;
        this.userId = userId;
        this.filmId = filmId;
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
}
