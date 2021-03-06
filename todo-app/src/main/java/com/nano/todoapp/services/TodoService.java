package com.nano.todoapp.services;

import com.nano.todoapp.pojo.Todo;
import com.nano.todoapp.util.ResponseUtil;

public interface TodoService {
	
	public ResponseUtil getTodos();
	
	public ResponseUtil addTodo(Todo todo);
	
	public ResponseUtil getTodo(int id);

	public ResponseUtil updateTodo(int id, Todo updatedTodo);
}
