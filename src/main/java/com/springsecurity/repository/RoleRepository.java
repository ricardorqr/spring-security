package com.springsecurity.repository;

import com.springsecurity.model.Role;
import com.springsecurity.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(RoleEnum name);


}
