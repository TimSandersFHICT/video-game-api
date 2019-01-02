package api.controller;

import api.exceptions.DatabaseException;
import api.exceptions.EmptyRequestBodyException;
import api.exceptions.ResourceNotFoundException;
import api.model.Game;
import api.requestbodies.GameRequestBody;
import api.responsebodies.GameResponseBody;
import api.services.interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/game")
@CrossOrigin
public class GameController {

    @Autowired
    private IGameService gameService;

    @GetMapping(value = "/all")
    public ResponseEntity<Object> getGames()
    {
        List<GameResponseBody> games;
        try {
            games = gameService.getGames();
        } catch (DatabaseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping(value = "/{gameId}")
    public ResponseEntity<Object> getGameById(@PathVariable("gameId") Long gameId) {
        Game game;
        try {
            game = gameService.getGameById(gameId);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (DatabaseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (EmptyRequestBodyException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Object> postNewGame(@RequestBody GameRequestBody gameRequestBody) {
        try {
            gameService.createNewGame(gameRequestBody);
        } catch (EmptyRequestBodyException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (DatabaseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
