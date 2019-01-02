package api.services;

import api.exceptions.DatabaseException;
import api.exceptions.EmptyRequestBodyException;
import api.exceptions.ResourceNotFoundException;
import api.model.Game;
import api.repositories.GameRepository;
import api.requestbodies.GameRequestBody;
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
            throw new DatabaseException(e.getMessage());
        }
        return games;
    }

    @Override
    public Game getGameById(Long id) throws EmptyRequestBodyException, ResourceNotFoundException, DatabaseException{
        if (id == null) {
            throw new EmptyRequestBodyException("There was no given, or valid ID");
        }
        Game game;
        try {
            game = gameRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("There is no student house with such ID"));
        } catch (Exception e) {
            throw new DatabaseException("Something went wrong while accessing the data");
        }
        return game;
    }

    @Override
    public void createNewGame(GameRequestBody gameRequestBody) throws EmptyRequestBodyException, DatabaseException {
        if (gameRequestBody == null) {
            throw new EmptyRequestBodyException("The request body was empty");
        }

        Game game = new Game(
                gameRequestBody.getTitle(),
                gameRequestBody.getSummary(),
                gameRequestBody.getPrice(),
                gameRequestBody.getReleaseDate(),
                gameRequestBody.getRating(),
                gameRequestBody.getImageLink(),
                gameRequestBody.getDeveloper(),
                gameRequestBody.getGenre()
        );

        try {
            gameRepository.save(game);
        } catch (Exception e) {
            throw new DatabaseException("Something wrong while saving the data");
        }
    }
}
