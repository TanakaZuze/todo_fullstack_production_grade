package dev.tanaka.todo_fullstack_production_grade.repository;

import dev.tanaka.todo_fullstack_production_grade.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleDescription(String roleDescription);
}
