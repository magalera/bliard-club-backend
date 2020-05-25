package com.magalera.bilardclub.repository;

import com.magalera.bilardclub.domain.Prices;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public interface PricesRepository extends CrudRepository<Prices, Long> {
}
