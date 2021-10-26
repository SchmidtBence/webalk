package hu.me.iit.webapps.db;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public Iterable<People> getAllPeople() {
        return peopleRepository.findAll();
    }
}
