package com.springsecurity.controller;

import com.springsecurity.model.User;
import com.springsecurity.service.UserService;
import com.springsecurity.swagger.user.api.UserApi;
import com.springsecurity.swagger.user.model.UserAndRolesResponse;
import com.springsecurity.swagger.user.model.UserDTO;
import com.springsecurity.swagger.user.model.UserRequest;
import com.springsecurity.swagger.user.model.UsersAndRolesResponse;
import com.springsecurity.util.Util;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController implements UserApi {

    private UserService userService;

    @Override
    public ResponseEntity<UserDTO> addUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public ResponseEntity<UsersAndRolesResponse> getUsers() {
        log.info("Request all users");
        List<User> users = userService.getUsers();

        UsersAndRolesResponse response = new UsersAndRolesResponse();
        List<UserAndRolesResponse> userAndRoles = users.stream()
                                                       .map(Util::modelToDTO)
                                                       .collect(Collectors.toList());
        response.setUsers(userAndRoles);
        response.setSize(userAndRoles.size());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
