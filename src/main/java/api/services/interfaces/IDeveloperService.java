package api.services.interfaces;

import api.exceptions.DatabaseException;
import api.exceptions.EmptyRequestBodyException;
import api.model.Developer;
import api.requestbodies.DeveloperRequestBody;
import api.responsebodies.DeveloperResponseBody;

import java.util.List;

public interface IDeveloperService {
    List<DeveloperResponseBody> getDevelopers() throws DatabaseException;
    void createNewDeveloper(DeveloperRequestBody developerRequestBody) throws EmptyRequestBodyException, DatabaseException;
}
