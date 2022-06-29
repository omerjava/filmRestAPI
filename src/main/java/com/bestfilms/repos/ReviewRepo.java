package com.bestfilms.repos;

import com.bestfilms.entities.Review;
import com.bestfilms.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findByFilmId(Long filmId);
    List<Review> findByUserId(Long userId);

}
