package api.services.interfaces;

import api.exceptions.DatabaseException;
import api.exceptions.EmptyRequestBodyException;
import api.model.Developer;
import api.requestbodies.DeveloperRequestBody;

import java.util.List;

public interface IDeveloperService {
    List<Developer> getDevelopers();
    void createNewDeveloper(DeveloperRequestBody developerRequestBody) throws EmptyRequestBodyException, DatabaseException;
}
