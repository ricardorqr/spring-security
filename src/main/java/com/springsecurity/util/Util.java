package com.springsecurity.util;

import com.springsecurity.model.Role;
import com.springsecurity.model.RoleEnum;
import com.springsecurity.model.User;
import com.springsecurity.swagger.user.model.*;

import java.util.stream.Collectors;

public class Util {

    public static RoleResponse modelToDtoBasic(Role role) {
        RoleResponse dto = new RoleResponse();
        dto.setName(role.getName()
                        .getValue());
        return dto;
    }

    public static UserAndRolesResponse modelToDto(User user) {
        UserAndRolesResponse dto = new UserAndRolesResponse();
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setRoles(user.getRoles()
                         .stream()
                         .map(Util::modelToDtoBasic)
                         .collect(Collectors.toList()));
        return dto;
    }

    public static UserResponse modelToDtoBasic(User user) {
        UserResponse dto = new UserResponse();
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        return dto;
    }

    public static User dtoToModel(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .password(userRequest.getPassword())
                .username(userRequest.getUsername())
                .build();
    }

    public static Role dtoToModel(RoleRequest roleRequest) {
        return Role.builder()
                .name(RoleEnum.fromValue(roleRequest.getName()))
                .build();
    }

}
