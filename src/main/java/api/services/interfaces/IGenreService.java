package api.services.interfaces;

import api.exceptions.DatabaseException;
import api.exceptions.EmptyRequestBodyException;
import api.model.Genre;
import api.requestbodies.GenreRequestBody;

import java.util.List;

public interface IGenreService {
    List<Genre> getGenres();
    void createNewGenre(GenreRequestBody developerRequestBody) throws EmptyRequestBodyException, DatabaseException;
}
