package com.springsecurity.controller;

import com.springsecurity.model.User;
import com.springsecurity.service.UserService;
import com.springsecurity.swagger.user.api.UserApi;
import com.springsecurity.swagger.user.model.UserDTO;
import com.springsecurity.swagger.user.model.UserRequest;
import com.springsecurity.swagger.user.model.UserResponse;
import com.springsecurity.swagger.user.model.UsersResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class UserController implements UserApi {

    private UserService userService;

    @Override
    public ResponseEntity<UserResponse> addUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public ResponseEntity<UsersResponse> getUsers() {
        List<User> users = userService.getUsers();
        UsersResponse usersResponse = new UsersResponse();
        List<UserDTO> userDTOs = users.stream()
                                      .map(user -> {
                                          UserDTO userDTO = new UserDTO();
                                          userDTO.setName(user.getName());
                                          userDTO.setUsername(user.getUsername());
                                          userDTO.setPassword(user.getPassword());
                                          return userDTO;
                                      })
                                      .collect(Collectors.toList());
        usersResponse.setUsers(userDTOs);
        usersResponse.setSize(userDTOs.size());
        return new ResponseEntity<>(usersResponse, HttpStatus.OK);
    }

}
