package api.controller;

import api.exceptions.DatabaseException;
import api.exceptions.EmptyRequestBodyException;
import api.requestbodies.DeveloperRequestBody;
import api.responsebodies.DeveloperResponseBody;
import api.responsebodies.GameResponseBody;
import api.services.interfaces.IDeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/developer")
@CrossOrigin
public class DeveloperController {

    @Autowired
    private IDeveloperService developerService;

    @GetMapping(value = "/all")
    public ResponseEntity<Object> getDevelopers()
    {
        List<DeveloperResponseBody> developers;
        try {
            developers = developerService.getDevelopers();
        } catch (DatabaseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(developers, HttpStatus.OK);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Object> postNewDeveloper(@RequestBody DeveloperRequestBody developerRequestBody) {
        try {
            developerService.createNewDeveloper(developerRequestBody);
        } catch (EmptyRequestBodyException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (DatabaseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
