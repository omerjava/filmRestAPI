package com.bestfilms.repos;

import com.bestfilms.entities.Film;
import com.bestfilms.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepo extends JpaRepository<Film, Long> {
    List<Film> findByTitleContainingIgnoreCase(String title);
    List<Film> findByPlotContainingIgnoreCase(String plot);
}
