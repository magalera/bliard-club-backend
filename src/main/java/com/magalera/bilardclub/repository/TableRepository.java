package com.magalera.bilardclub.repository;

import com.magalera.bilardclub.domain.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface TableRepository extends CrudRepository<Table, Long> {
    Table findByNumber(Integer number);


}
