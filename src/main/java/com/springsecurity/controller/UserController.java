package com.springsecurity.controller;

import com.springsecurity.model.Role;
import com.springsecurity.model.RoleEnum;
import com.springsecurity.model.User;
import com.springsecurity.service.UserService;
import com.springsecurity.swagger.user.api.UserApi;
import com.springsecurity.swagger.user.model.*;
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
    public ResponseEntity<UserAndRolesResponse> addRoleToUSer(UserAndRoleRequest userAndRoleRequest) {
        log.info("Request add a role to a user");
        User user = User.builder()
                        .username(userAndRoleRequest.getUsername())
                        .build();
        Role role = Role.builder()
                        .name(RoleEnum.fromValue(userAndRoleRequest.getRole()))
                        .build();
        User updatedUser = userService.addRoleToUser(user, role);
        return new ResponseEntity<>(Util.modelToDtoFull(updatedUser), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponse> addUser(UserRequest userRequest) {
        log.info("Request add a new user");
        User user = userService.saveUser(Util.dtoToModel(userRequest));
        return new ResponseEntity<>(Util.modelToDto(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UsersAndRolesResponse> getUsers() {
        log.info("Request all users");
        List<User> users = userService.getUsers();

        UsersAndRolesResponse response = new UsersAndRolesResponse();
        List<UserAndRolesResponse> userAndRoles = users.stream()
                                                       .map(Util::modelToDtoFull)
                                                       .collect(Collectors.toList());
        response.setUsers(userAndRoles);
        response.setSize(userAndRoles.size());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
