package com.magalera.bilardclub.repository;


import com.magalera.bilardclub.domain.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CityRepository  extends CrudRepository<City, Long> {
}
