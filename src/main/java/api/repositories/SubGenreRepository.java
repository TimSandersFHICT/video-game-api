package api.repositories;

import api.model.SubGenre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubGenreRepository extends CrudRepository<SubGenre, Long> {
}
