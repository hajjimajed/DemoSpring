package com.example.DemoSpring.Repository;

import com.example.DemoSpring.Model.ERole;
import com.example.DemoSpring.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
Optional<Role> findByName(ERole name);
}
