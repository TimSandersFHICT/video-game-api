package api.services;

import api.model.Developer;
import api.repositories.DeveloperRepository;
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
}
