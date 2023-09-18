package com.todo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.api.model.Task;
import com.todo.api.repository.ITodoRepository;

@RestController
public class TodoController {
	@Autowired
	private ITodoRepository todoRepository;
	
	@GetMapping(value = "/")
	public String holaMundo() {
		return "HOLA MUNDO";
	}
	
	@GetMapping(value = "/tasks")
	public List<Task> getTasks(){
		return todoRepository.findAll();
	}
	
	@PostMapping(value = "/newtask")
	public String saveTask(@RequestBody Task task) {
		todoRepository.save(task);
		return "Saved Task";
	}
	
	@PutMapping(value = "/update/{id}")
	public String updateTask(@PathVariable long id, @RequestBody Task task) {
		
		Task updatedTask = todoRepository.findById(id).get();
		
		updatedTask.setTitle(task.getTitle());
		updatedTask.setDescription(task.getDescription());
		
		todoRepository.save(updatedTask);
		return "Updated Task";
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteTask(@PathVariable long id) {
		todoRepository.deleteById(id);
		return "Deleted Task";
	}

}
