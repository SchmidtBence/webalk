package hu.me.iit.webapps.db.service;

import hu.me.iit.webapps.db.repository.People;
import hu.me.iit.webapps.db.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public Iterable<People> getAllPeople() {
        List<People> rv=new ArrayList<>();


        for (hu.me.iit.webapps.db.repository.People people : peopleRepository.findAll()) {
            rv.add(new People(people));
        }

        return rv;
    }

    public Iterable<People> getAllPeople() {
        return StreamSupport.stream(peopleRepository.findAll().spliterator(),false)
                .map(People::new)
                .collect(Collectors.toList());
    }

    @Override
    public hu.me.iit.webapps.db.service.People create(hu.me.iit.webapps.db.service.People toPeople){
        hu.me.iit.webapps.db.repository.People peopledb=new hu.me.iit.webapps.db.repository.People();
        peopledb.setAge(toPeople.getAge());
        peopledb.setName(toPeople.getName());
        peopleRepository
    }
}
