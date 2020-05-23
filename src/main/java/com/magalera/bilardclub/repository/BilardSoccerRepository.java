package com.magalera.bilardclub.repository;

import com.magalera.bilardclub.domain.BilardSoccer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface BilardSoccerRepository extends CrudRepository<BilardSoccer, Long> {
    BilardSoccer findBilardSoccerByNumber(Integer number);
}
