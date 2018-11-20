package api.controller;

import api.exceptions.DatabaseException;
import api.responsebodies.GameResponseBody;
import api.services.interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
