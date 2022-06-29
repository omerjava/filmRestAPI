package com.bestfilms.controllers;

import com.bestfilms.entities.Film;
import com.bestfilms.entities.Review;
import com.bestfilms.repos.ReviewRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

    private final ReviewRepo reviewRepo;

    public ReviewController(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @PostMapping("/reviews")
    Review addReview(@RequestBody Review review){
        return reviewRepo.save(review);
    }

    @GetMapping("/reviews")
    List<Review> getReviews(){
        return reviewRepo.findAll();
    }

    @GetMapping("reviews/{id}")
    Optional<Review> getReviewById(@PathVariable Optional<Long> id){
        return reviewRepo.findById(id.orElseGet(() -> null));
    }

    @GetMapping("films/{id}/reviews")
    List<Review> getReviewsByFilmId(@PathVariable Long id){
        return reviewRepo.findByFilmId(id);
    }

    @GetMapping("users/{id}/reviews")
    List<Review> getReviewsByUserId(@PathVariable Long id){
        return reviewRepo.findByUserId(id);
    }

    @PutMapping("/reviews/{id}")
    Review updateReview(@RequestBody Review newReview, @PathVariable Long id){
        return reviewRepo.findById(id)
                .map(review -> {
                    review.setReview(newReview.getReview());
                    return reviewRepo.save(review);
                })
                .orElseGet(() -> reviewRepo.save(newReview));
    }

    @DeleteMapping("/reviews/{id}")
    void deleteReviewById(@PathVariable Long id){
        reviewRepo.deleteById(id);
    }

}
