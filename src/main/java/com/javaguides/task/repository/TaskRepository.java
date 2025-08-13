package com.javaguides.task.repository;

import com.javaguides.task.entity.Task;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Object> findById(Log taskId);
}
