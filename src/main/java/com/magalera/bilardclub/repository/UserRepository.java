package com.magalera.bilardclub.repository;

import com.magalera.bilardclub.domain.User;
import com.magalera.bilardclub.domain.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
