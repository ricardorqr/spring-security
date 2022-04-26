package com.springsecurity.util;

import com.springsecurity.model.Role;
import com.springsecurity.model.User;
import com.springsecurity.swagger.user.model.RoleDTO;
import com.springsecurity.swagger.user.model.UserAndRolesResponse;

import java.util.stream.Collectors;

public class Util {

    public static RoleDTO modelToDTO(Role role) {
        RoleDTO dto = new RoleDTO();
        dto.setName(role.getName()
                        .getValue());
        return dto;
    }

    public static UserAndRolesResponse modelToDTO(User user) {
        UserAndRolesResponse dto = new UserAndRolesResponse();
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setRoles(user.getRoles()
                         .stream()
                         .map(Util::modelToDTO)
                         .collect(Collectors.toList()));
        return dto;
    }

}
