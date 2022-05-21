package com.springsecurity.service;

import com.springsecurity.model.Role;
import com.springsecurity.model.User;
import com.springsecurity.repository.RoleRepository;
import com.springsecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.warn("User not found in DB");
            throw new UsernameNotFoundException("User not found in DB");
        }

        log.info("User found in DB: {}", user);

        List<SimpleGrantedAuthority> authorities = user.getRoles()
                                                       .stream()
                                                       .map(role -> new SimpleGrantedAuthority(role.getName()
                                                                                                   .getValue()))
                                                       .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
        return userRepository.findAll();
    }

}
