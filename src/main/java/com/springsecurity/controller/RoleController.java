package com.springsecurity.controller;

import com.springsecurity.model.Role;
import com.springsecurity.service.RoleService;
import com.springsecurity.swagger.user.api.RoleApi;
import com.springsecurity.swagger.user.model.RolesResponse;
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
public class RoleController implements RoleApi {

    private RoleService roleService;

    @Override
    public ResponseEntity<RolesResponse> getRoles() {
        log.info("Request all roles");
        List<Role> roles = roleService.getRoles();

        RolesResponse rolesResponse = new RolesResponse();
        rolesResponse.setSize(roles.size());
        rolesResponse.setRoles(roles.stream().map(Util::modelToDtoFull).collect(Collectors.toList()));
        return new ResponseEntity<>(rolesResponse, HttpStatus.OK);
    }

}
