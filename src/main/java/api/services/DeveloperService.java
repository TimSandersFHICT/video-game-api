package api.services;

import api.exceptions.DatabaseException;
import api.exceptions.EmptyRequestBodyException;
import api.model.Developer;
import api.repositories.DeveloperRepository;
import api.requestbodies.DeveloperRequestBody;
import api.responsebodies.DeveloperResponseBody;
import api.services.interfaces.IDeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeveloperService implements IDeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public List<DeveloperResponseBody> getDevelopers() throws DatabaseException {
        List<DeveloperResponseBody> developers = new ArrayList<>();
        try {
            developerRepository.findAll().forEach(s -> developers.add(
                    new DeveloperResponseBody(s.getId(), s.getName(), s.getAddress(), s.getNumEmployees(), s.getDateFounded())
            ));
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
        return developers;
    }

    @Override
    public void createNewDeveloper(DeveloperRequestBody developerRequestBody) throws EmptyRequestBodyException, DatabaseException {
        if (developerRequestBody == null) {
            throw new EmptyRequestBodyException("The request body was empty");
        }

        Developer developer = new Developer(
                developerRequestBody.getName(),
                developerRequestBody.getAddress(),
                developerRequestBody.getNumEmployees(),
                developerRequestBody.getDateFounded()
        );

        try {
            developerRepository.save(developer);
        } catch (Exception e) {
            throw new DatabaseException("Something wrong while saving the data");
        }
    }
}
