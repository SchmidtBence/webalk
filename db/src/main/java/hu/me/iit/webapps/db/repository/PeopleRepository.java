package hu.me.iit.webapps.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PeopleRepository extends PagingAndSortingRepository<PeopleModel, Long> {
    Iterable<PeopleModel> findAllByAgeGreaterThanEqual(int age);
}
