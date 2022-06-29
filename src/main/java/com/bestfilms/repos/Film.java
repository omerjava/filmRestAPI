package com.bestfilms.repos;

import java.util.List;

public interface Film {
    Long getFilmId();

    String getTitle();

    String getReleased();

    String getImages();

    String getPlot();

    List<ReviewInfo> getReviews();

    interface ReviewInfo {
        Long getReviewId();

        String getReview();

        Long getUserId();

        Long getFilmId();

        com.bestfilms.entities.Film getFilm();
    }
}
