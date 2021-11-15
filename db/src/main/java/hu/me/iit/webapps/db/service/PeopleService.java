package hu.me.iit.webapps.db.service;


public interface PeopleService {
    Iterable<People> getAllPeople();
    People create(People people);

    void delete(Long id);

    People getById(Long id) throws NoSuchEntityException;

    void save(People people);

    Iterable findByIdAgeGreather(int age);
}
