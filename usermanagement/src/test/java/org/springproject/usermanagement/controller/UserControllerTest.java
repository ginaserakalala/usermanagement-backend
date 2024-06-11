package org.springproject.usermanagement.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springproject.usermanagement.model.User;
import org.springproject.usermanagement.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getAllUsers(){
        //Given
        List<User> users = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(users);

        //When
        List<User> result = userController.getAllUsers();

        //Then
        assertEquals(users.size(), result.size());
        assertEquals(users.get(0).getUsername(), result.get(0).getUsername());
    }

    @Test
    void addUser() {
        //Given
        User user = new User(1l, "jubilee","jubilee@test.com","test","0787837788");
        when(userRepository.existsById(1L)).thenReturn(true);

        //When
        ResponseEntity<String> responseEntity = userController.addUser(user);

        //Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}