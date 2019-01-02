package api.services;

import api.exceptions.DatabaseException;
import api.exceptions.EmptyRequestBodyException;
import api.model.Developer;
import api.model.Genre;
import api.repositories.GenreRepository;
import api.requestbodies.GenreRequestBody;
import api.responsebodies.GenreResponseBody;
import api.services.interfaces.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService implements IGenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<GenreResponseBody> getGenres() throws DatabaseException {
        List<GenreResponseBody> genres = new ArrayList<>();
        try {
            genreRepository.findAll().forEach(s -> genres.add(
                    new GenreResponseBody(s.getId(), s.getName())
            ));
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
        return genres;
    }

    @Override
    public void createNewGenre(GenreRequestBody developerRequestBody) throws EmptyRequestBodyException, DatabaseException {
        if (developerRequestBody == null) {
            throw new EmptyRequestBodyException("The request body was empty");
        }

        Genre genre = new Genre(
                developerRequestBody.getName()
        );

        try {
            genreRepository.save(genre);
        } catch (Exception e) {
            throw new DatabaseException("Something wrong while saving the data");
        }
    }
}
