package api.services;

import api.model.Game;
import api.repositories.GameRepository;
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
    public List<Game> getGames() {
        List<Game> games = new ArrayList<>();
        try {
            gameRepository.findAll().forEach(r -> games.add(r));
        } catch (Exception e) {
            return null;
        }
        return games;
    }
}
