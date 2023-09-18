package com.todo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.api.model.Task;

public interface ITodoRepository extends JpaRepository<Task, Long>{
}
