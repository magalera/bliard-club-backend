package com.magalera.bilardclub.repository;

import com.magalera.bilardclub.domain.User;
import com.magalera.bilardclub.domain.UserType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTestSuite {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserRepository(){
        // Given
        User user = User.builder().type(UserType.BILLIARD_PLAYER).firstName("Tommy").lastName("Sullivan").email("tommy.sullivan@gmail.com").password("xYz!@#").build();

        // When
        User saved = userRepository.save(user);

        // Then
        Long id = saved.getId();
        Optional<User> actualUser = userRepository.findById(id);
        assertTrue(actualUser.isPresent());

        // CleanUp
        userRepository.deleteById(id);
    }
}