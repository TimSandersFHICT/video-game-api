package api.controller;

import api.exceptions.DatabaseException;
import api.exceptions.EmptyRequestBodyException;
import api.requestbodies.GenreRequestBody;
import api.responsebodies.GenreResponseBody;
import api.services.interfaces.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/genre")
@CrossOrigin
public class GenreController {

    @Autowired
    private IGenreService genreService;

    @GetMapping(value = "/all")
    public ResponseEntity<Object> getGenres()
    {
        List<GenreResponseBody> genres;
        try {
            genres = genreService.getGenres();
        } catch (DatabaseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Object> postNewDeveloper(@RequestBody GenreRequestBody genreRequestBody) {
        try {
            genreService.createNewGenre(genreRequestBody);
        } catch (EmptyRequestBodyException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (DatabaseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
