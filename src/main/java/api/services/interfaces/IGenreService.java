package api.services.interfaces;

import api.exceptions.DatabaseException;
import api.exceptions.EmptyRequestBodyException;
import api.model.Genre;
import api.requestbodies.GenreRequestBody;
import api.responsebodies.GenreResponseBody;

import java.util.List;

public interface IGenreService {
    List<GenreResponseBody> getGenres() throws DatabaseException;
    void createNewGenre(GenreRequestBody developerRequestBody) throws EmptyRequestBodyException, DatabaseException;
}
