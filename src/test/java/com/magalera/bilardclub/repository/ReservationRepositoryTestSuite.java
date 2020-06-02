package com.magalera.bilardclub.repository;

import com.magalera.bilardclub.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationRepositoryTestSuite {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private TableRepository tableRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testReservationRepository() {
        // Give
        Table table1 = Table.builder().number(1).build();
        tableRepository.save(table1);
        Timestamp startDate = Timestamp.valueOf(LocalDateTime.now());
        Timestamp endDate = Timestamp.valueOf(LocalDateTime.now());
        User user = User.builder().type(UserType.BILLIARD_PLAYER).firstName("Tommy").lastName("Sullivan").email("tommy.sullivan@gmail.com").password("xYz!@#").build();
        userRepository.save(user);
        Reservation reservation = Reservation.builder().table(table1).type(ReservationType.TABLE).startDate(startDate).endDate(endDate).user(user).build();

        // When
        Reservation saved = reservationRepository.save(reservation);

        // Then
        Long id = saved.getId();
        Optional<Reservation> actualReservation = reservationRepository.findById(id);
        assertTrue(actualReservation.isPresent());
        System.out.println("THE TIME " + reservation.getStartDate().toString());

        // CleanUp
        reservationRepository.deleteById(id);
    }
}