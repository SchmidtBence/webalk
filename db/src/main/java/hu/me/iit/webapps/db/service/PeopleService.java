package hu.me.iit.webapps.db.service;


public interface PeopleService {
    Iterable<People> getAllPeople();
    People create(People people);
}
