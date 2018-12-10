package api.services;

import api.exceptions.DatabaseException;
import api.model.Game;
import api.repositories.GameRepository;
import api.responsebodies.GameResponseBody;
import api.services.interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService implements IGameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<GameResponseBody> getGames() throws DatabaseException {
        List<GameResponseBody> games = new ArrayList<>();
        try {
            gameRepository.findAll().forEach(s -> games.add(
                    new GameResponseBody(s.getId(), s.getTitle(), s.getSummary(), s.getPrice(), null, s.getRating(), s.getImageLink(), s.getDeveloper(), s.getGenre())
            ));
        } catch (Exception e) {
            throw new DatabaseException(e.getStackTrace().toString());
        }
        return games;
    }
}
