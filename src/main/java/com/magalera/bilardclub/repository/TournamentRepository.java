package com.magalera.bilardclub.repository;

import com.magalera.bilardclub.domain.Table;
import com.magalera.bilardclub.domain.Tournament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {
    Optional<Tournament> findById (Long id);
}
