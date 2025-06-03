package dev.tanaka.todo_fullstack_production_grade.repository;

import dev.tanaka.todo_fullstack_production_grade.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
