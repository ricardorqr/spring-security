package com.springsecurity.service;

import com.springsecurity.model.Role;
import com.springsecurity.model.User;
import com.springsecurity.repository.RoleRepository;
import com.springsecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class RoleService {

    private final RoleRepository roleRepository;

    public Role saveRole(Role role) {
        log.info("Save role: {}", role);
        return roleRepository.save(role);
    }

    public List<Role> getRoles() {
        log.info("Fetch all roles");
        return roleRepository.findAll();
    }

}
