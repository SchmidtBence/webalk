package hu.me.iit.gyak.gyak.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface LicitRepository extends PagingAndSortingRepository<Licit,Long> {

    Optional<Licit> findTopByOrederByLicitDesc();

    Optional<Licit> findTopByUserIdAndOrderByLicitDesc(Integer userId);
}
