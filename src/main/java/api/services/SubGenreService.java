package api.services;

import api.model.SubGenre;
import api.repositories.SubGenreRepository;
import api.services.interfaces.ISubGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubGenreService implements ISubGenreService {

    @Autowired
    private SubGenreRepository subGenreRepository;

    @Override
    public List<SubGenre> getSubGenres() {
        List<SubGenre> subGenres = new ArrayList<>();
        try {
            subGenreRepository.findAll().forEach(r -> subGenres.add(r));
        } catch (Exception e) {
            return null;
        }
        return subGenres;
    }
}
