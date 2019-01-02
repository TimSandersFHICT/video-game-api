package api.services;

import api.exceptions.DatabaseException;
import api.exceptions.EmptyRequestBodyException;
import api.model.Developer;
import api.repositories.DeveloperRepository;
import api.requestbodies.DeveloperRequestBody;
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
    public List<Developer> getDevelopers() {
        List<Developer> developers = new ArrayList<>();
        try {
            developerRepository.findAll().forEach(r -> developers.add(r));
        } catch (Exception e) {
            return null;
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
