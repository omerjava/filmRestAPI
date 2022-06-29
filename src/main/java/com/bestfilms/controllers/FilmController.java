package com.bestfilms.controllers;


import com.bestfilms.entities.Film;
import com.bestfilms.exceptions.FilmNotFoundException;
import com.bestfilms.repos.FilmRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FilmController {

    private final FilmRepo filmRepo;

    public FilmController(FilmRepo filmRepo) {
        this.filmRepo = filmRepo;
    }

    @GetMapping("/films")
    List<Film> getFilms(){
        return filmRepo.findAll();
    }

    @GetMapping("/films/{id}")
    Film getFilmById(@PathVariable Long id) {

        return filmRepo.findById(id)
                .orElseThrow(() -> new FilmNotFoundException(id));
    }


    @PostMapping(value = "/filmAdded")
    String saveFilm(@RequestBody Film newFilm) {
        filmRepo.save(newFilm);
        return "Saved...";
    }

    // alternative
    @PostMapping("/films")
    Film addNewFilm(@RequestBody Film newFilm) {
        return filmRepo.save(newFilm);
    }

    @PutMapping("/films/{id}")
    Film replaceFilm(@RequestBody Film newFilm, @PathVariable Long id) {

        return filmRepo.findById(id)
                .map(film -> {
                    film.setTitle(newFilm.getTitle());
                    film.setReleased(newFilm.getReleased());
                    film.setActors(newFilm.getActors());
                    film.setAwards(newFilm.getAwards());
                    film.setGenre(newFilm.getGenre());
                    film.setImages(newFilm.getImages());
                    film.setPlot(newFilm.getPlot());
                    film.setDirector(newFilm.getDirector());
                    return filmRepo.save(film);
                })
                .orElseGet(() -> {
                    newFilm.setFilmId(id);
                    return filmRepo.save(newFilm);
                });
    }

    @DeleteMapping("/films/{id}")
    void deleteFilm(@PathVariable Long id) {
        filmRepo.deleteById(id);
    }

    // Query String parameters
    @GetMapping("/films/query")
     List<Film> getFilmsContainsSearchTermsInTitle(
            @RequestParam(value="search", required = false) String search,
            @RequestParam(value="field", required = false) String field) {

        if(Objects.equals(field, "plot")) return filmRepo.findByPlotContainingIgnoreCase(search);
        if(Objects.equals(field, "title")) return filmRepo.findByTitleContainingIgnoreCase(search);

        return null;
    }

    @GetMapping("/films/query2")
    List<Film> getFilmsContainsSearchTermsInTitle(
            @RequestParam(value="search", required = false) Optional<String> search,
            @RequestParam(value="field", required = false) String field) {

        if(Objects.equals(field, "plot")) return filmRepo.findByPlotContainingIgnoreCase(search.orElseGet(() -> null));
        if(Objects.equals(field, "title")) return filmRepo.findByTitleContainingIgnoreCase(search.orElseGet(() -> null));

        return null;
    }

}
