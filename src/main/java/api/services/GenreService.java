package api.services;

import api.model.Genre;
import api.repositories.GenreRepository;
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
    public List<Genre> getGenres() {
        List<Genre> genres = new ArrayList<>();
        try {
            genreRepository.findAll().forEach(r -> genres.add(r));
        } catch (Exception e) {
            return null;
        }
        return genres;
    }
}
