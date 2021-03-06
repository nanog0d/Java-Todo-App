package com.nano.todoapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nano.todoapp.pojo.CustomException;
import com.nano.todoapp.pojo.Todo;
import com.nano.todoapp.services.TodoService;
import com.nano.todoapp.util.ResponseUtil;

@RestController
@RequestMapping("/todo-app")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
//	@Autowired
//	private ResponseUtil responseUtil;
	
	@GetMapping("/todos")
	public ResponseUtil getTodos() {
		return this.todoService.getTodos();
	}
	
	@PostMapping("/todo")
	public ResponseUtil addTodo(@Valid @RequestBody Todo todo) throws CustomException{
		return this.todoService.addTodo(todo);
	}
	
	@GetMapping("/todo/{id}")
	public ResponseUtil getTodo(@PathVariable int id) throws CustomException{
		return this.todoService.getTodo(id);
	}
	
	@PutMapping("/todo/{id}")
	public ResponseEntity<Object> updateTodo(@PathVariable int id, @Valid @RequestBody Todo updatedTodo){
		return this.todoService.updateTodo(id, updatedTodo);
	}

}
