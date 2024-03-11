package com.app.crud.repository;

import com.app.crud.model.member.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    
}
