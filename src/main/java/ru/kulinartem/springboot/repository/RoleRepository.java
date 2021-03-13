package ru.kulinartem.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kulinartem.springboot.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
