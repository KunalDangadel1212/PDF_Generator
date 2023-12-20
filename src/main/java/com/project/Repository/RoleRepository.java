package com.project.Repository;

import org.springframework.data.repository.CrudRepository;

import com.project.Entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    
}