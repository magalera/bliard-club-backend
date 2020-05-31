package com.magalera.bilardclub.controller;

import com.google.gson.Gson;
import com.magalera.bilardclub.domain.User;
import com.magalera.bilardclub.domain.UserDto;
import com.magalera.bilardclub.domain.UserType;
import com.magalera.bilardclub.mapper.UserMapper;
import com.magalera.bilardclub.repository.UserRepository;
import com.magalera.bilardclub.service.UserDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserRepository repository;
    @MockBean
    private UserDbService service;
    @MockBean
    private UserMapper mapper;

    @Test
    public void testRegistration() throws Exception {
        // Given
        User user = User.builder().type(UserType.BILLIARD_PLAYER).firstName("Tommy").lastName("Sullivan").email("tommy.sullivan@gmail.com").password("xYz!@#").build();
        UserDto userDto = UserDto.builder().type(UserType.BILLIARD_PLAYER).firstName("Tommy").lastName("Sullivan").email("tommy.sullivan@gmail.com").password("xYz!@#").build();

        when(repository.save(user)).thenReturn(user);
        when(mapper.mapToUserDto(user)).thenReturn(userDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);

        // When & Then
        mockMvc.perform(post("/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testLogIn() throws Exception {
        // Given
        User user = User.builder().type(UserType.BILLIARD_PLAYER).firstName("Tommy").lastName("Sullivan").email("tommy.sullivan@gmail.com").password("xYz!@#").build();
        UserDto userdto = UserDto.builder().type(UserType.BILLIARD_PLAYER).firstName("Tommy").lastName("Sullivan").email("tommy.sullivan@gmail.com").password("xYz!@#").build();

        when(repository.save(user)).thenReturn(user);
        when(service.logIn(user.getEmail(), user.getPassword())).thenReturn(user);
        when(mapper.mapToUserDto(user)).thenReturn(userdto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(userdto);

        // When & Then
        mockMvc.perform(post("/v1/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdate() throws Exception {
        // Given
        User user = User.builder().type(UserType.BILLIARD_PLAYER).firstName("Tommy").lastName("Sullivan").email("tommy.sullivan@gmail.com").password("xYz!@#").build();
        UserDto userDto = UserDto.builder().type(UserType.BILLIARD_PLAYER).firstName("Tommy").lastName("Sullivan").email("tommy.sullivan@gmail.com").password("xYz!@#").build();

        when(repository.save(user)).thenReturn(user);
        when(mapper.mapToUserDto(user)).thenReturn(userDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);

        // When & Then
        mockMvc.perform(put("/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}