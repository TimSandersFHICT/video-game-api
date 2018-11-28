package api.services.interfaces;

import api.exceptions.DatabaseException;
import api.model.Game;
import api.responsebodies.GameResponseBody;

import java.util.List;

public interface IGameService {
    List<GameResponseBody> getGames() throws DatabaseException;;
}
