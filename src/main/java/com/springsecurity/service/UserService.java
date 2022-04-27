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
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public User saveUser(User user) {
        log.info("Save user: {}", user);
        return userRepository.save(user);
    }

    public User addRoleToUser(User user, Role role) {
        log.info("Add the role {} to the user {}", role.getName().getValue(), user.getUsername());
        User userFound = userRepository.findByUsername(user.getUsername());
        Role roleFound = roleRepository.findByName(role.getName());
        userFound.getRoles().add(roleFound);
        return userFound;
    }

    public List<User> getUsers() {
        log.info("Fetch all users");
        return userRepository.findAll();
    }

}
