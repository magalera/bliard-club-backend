package com.magalera.bilardclub.controller;

import com.google.gson.Gson;
import com.magalera.bilardclub.domain.*;
import com.magalera.bilardclub.mapper.ReservationMapper;
import com.magalera.bilardclub.mapper.TableMapper;
import com.magalera.bilardclub.mapper.UserMapper;
import com.magalera.bilardclub.repository.ReservationRepository;
import com.magalera.bilardclub.repository.TableRepository;
import com.magalera.bilardclub.service.ReservationDbService;
import com.magalera.bilardclub.service.TableDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ReservationRepository repository;
    @MockBean
    private ReservationDbService service;
    @MockBean
    private ReservationMapper mapper;

    @Test
    public void testCreate() throws Exception {
        // Given
        User user = User.builder().id(1L).type(UserType.BILLIARD_PLAYER).firstName("Tommy").lastName("Sullivan").email("tommy.sullivan@gmail.com").password("xYz!@#").build();
        UserDto userDto = UserDto.builder().id(1L).type(UserType.BILLIARD_PLAYER).firstName("Tommy").lastName("Sullivan").email("tommy.sullivan@gmail.com").password("xYz!@#").build();

        Timestamp start = Timestamp.from(Instant.now());
        Timestamp end = Timestamp.from(Instant.now());

        Reservation reservation = Reservation.builder().type(ReservationType.TABLE)
                .startDate(start)
                .endDate(end).user(user).build();
        ReservationDto reservationDto = ReservationDto.builder().type(ReservationType.TABLE)
                .startDate(start.getTime())
                .endDate(end.getTime()).user(userDto).build();

        when(repository.save(reservation)).thenReturn(reservation);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(reservationDto);

        // When & Then
        mockMvc.perform(post("/v1/reservation")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testShow() throws Exception {
        // Given
        User user = User.builder().id(1L).type(UserType.BILLIARD_PLAYER).firstName("Tommy").lastName("Sullivan").email("tommy.sullivan@gmail.com").password("xYz!@#").build();
        UserDto userDto = UserDto.builder().id(1L).type(UserType.BILLIARD_PLAYER).firstName("Tommy").lastName("Sullivan").email("tommy.sullivan@gmail.com").password("xYz!@#").build();

        Timestamp start = Timestamp.from(Instant.now());
        Timestamp end = Timestamp.from(Instant.now());

        Reservation reservation = Reservation.builder().id(1L).type(ReservationType.TABLE)
                .startDate(start)
                .endDate(end).user(user).build();
        ReservationDto reservationDto = ReservationDto.builder().id(1L).type(ReservationType.TABLE)
                .startDate(start.getTime())
                .endDate(end.getTime()).user(userDto).build();

        when(repository.findById(reservation.getId())).thenReturn(Optional.of(reservation));
        when(mapper.mapToReservationDto(reservation)).thenReturn(reservationDto);

        // When & Then
        mockMvc.perform(get("/v1/reservation/" + reservation.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(reservation.getId().intValue())))
                .andExpect(jsonPath("$.type", is(reservation.getType().toString())))
                .andExpect(jsonPath("$.startDate", is(reservation.getStartDate().getTime())))
                .andExpect(jsonPath("$.endDate", is(reservation.getEndDate().getTime())))
                .andExpect(jsonPath("$.user.id", is(reservation.getUser().getId().intValue())))
                .andExpect(jsonPath("$.user.type", is(reservation.getUser().getType().toString())))
                .andExpect(jsonPath("$.user.firstName", is(reservation.getUser().getFirstName())))
                .andExpect(jsonPath("$.user.lastName", is(reservation.getUser().getLastName())))
                .andExpect(jsonPath("$.user.email", is(reservation.getUser().getEmail())))
                .andExpect(jsonPath("$.user.password", is(reservation.getUser().getPassword())));
    }

    @Test
    public void testUpdate() throws Exception {
        // Given
        User user = User.builder().id(1L).type(UserType.BILLIARD_PLAYER).firstName("Tommy").lastName("Sullivan").email("tommy.j.s@gmail.com").password("xYz!@#").build();
        UserDto userDto = UserDto.builder().id(1L).type(UserType.BILLIARD_PLAYER).firstName("Tommy").lastName("Sullivan").email("tommy.j.s@gmail.com").password("xYz!@#").build();

        Timestamp start = Timestamp.from(Instant.now());
        Timestamp end = Timestamp.from(Instant.now());

        Reservation reservation = Reservation.builder().type(ReservationType.TABLE)
                .startDate(start)
                .endDate(end).user(user).build();
        ReservationDto reservationDto = ReservationDto.builder().type(ReservationType.TABLE)
                .startDate(start.getTime())
                .endDate(end.getTime()).user(userDto).build();

        when(repository.save(reservation)).thenReturn(reservation);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(reservationDto);

        // When & Then
        mockMvc.perform(put("/v1/reservation")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testCancel() throws Exception {
        // Given
        User user = User.builder().id(1L).type(UserType.BILLIARD_PLAYER).firstName("Tommy").lastName("Sullivan").email("tommy.sullivan@gmail.com").password("xYz!@#").build();

        Timestamp start = Timestamp.from(Instant.now());
        Timestamp end = Timestamp.from(Instant.now());

        Reservation reservation = Reservation.builder().id(1L).type(ReservationType.TABLE)
                .startDate(start)
                .endDate(end).user(user).build();

        when(repository.findById(reservation.getId())).thenReturn(Optional.of(reservation));

        // When & Then
        mockMvc.perform(delete("/v1/reservation/" + reservation.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}