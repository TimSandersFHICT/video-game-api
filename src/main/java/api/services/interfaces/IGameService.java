package api.services.interfaces;

import api.exceptions.DatabaseException;
import api.exceptions.EmptyRequestBodyException;
import api.exceptions.ResourceNotFoundException;
import api.model.Game;
import api.requestbodies.GameRequestBody;
import api.responsebodies.GameResponseBody;

import java.util.List;

public interface IGameService {
    List<GameResponseBody> getGames() throws DatabaseException;
    Game getGameById(Long id) throws EmptyRequestBodyException, ResourceNotFoundException, DatabaseException;
    void createNewGame(GameRequestBody gameRequestBody) throws EmptyRequestBodyException, DatabaseException;
}
