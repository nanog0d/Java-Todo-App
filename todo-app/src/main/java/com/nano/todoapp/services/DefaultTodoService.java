package com.nano.todoapp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nano.todoapp.dao.TodoDAO;
import com.nano.todoapp.pojo.Todo;
import com.nano.todoapp.util.ExceptionUtil;
import com.nano.todoapp.util.ResponseUtil;

@Service
@Transactional
public class DefaultTodoService implements TodoService {
	
//	@Autowired
//	private ResponseUtil responseUtil;
	
	private static int currentTodoId = 5;
	Map<String, Object> data;
	
	@Autowired
	private TodoDAO todoDAO;
	
//	private List<Todo> listOfTodos = new ArrayList<>(Arrays.asList(
//			new Todo(1, "Code", "Code till hibernate", false, new TimeStamp(), new Date()),
//			new Todo(2, "Java", "Java till hibernate", false, new Date(), new Date()),
//			new Todo(3, "AOP", "AOP till hibernate", false, new Date(), new Date()),
//			new Todo(4, "Exception Handling", "Exception Handling till hibernate", false, new Date(), new Date()),
//			new Todo(5, "Hibernate Connection", "DB setup and connection", false, new Date(), new Date())
//	));
	
	private List<Todo> listOfTodos = new ArrayList<>();

	@Override
	public ResponseUtil getTodos() {
		this.listOfTodos.addAll(this.todoDAO.findAll());
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("data", listOfTodos);
		data.put("status", HttpStatus.OK);
		return new ResponseUtil(data, HttpStatus.OK);
	}

	@Override
	public ResponseUtil addTodo(Todo todo){
		boolean exists = this.listOfTodos.stream().filter(currTodo -> currTodo.getTitle().equals(todo.getTitle())).findAny().isPresent();
		ExceptionUtil.throwExceptionIftrue(exists, "Todo with same id exists");
		if(todo.getId() == 0) todo.setId(++currentTodoId);
		this.listOfTodos.add(todo);
		
		data = new HashMap<String, Object>();
		data.put("data", todo);
		data.put("status", HttpStatus.OK);
		
		return new ResponseUtil(data, HttpStatus.OK);
	}

	@Override
	public ResponseUtil getTodo(int id) {
		Todo todo = null;
		Optional<Todo> opt = this.listOfTodos.stream().filter(existTodo -> existTodo.getId() == id).findAny();
		if(opt.isPresent()) todo = opt.get();
		else ExceptionUtil.throwExceptionIftrue(true, "Todo Not Found");
		
		data = new HashMap<String, Object>();
		data.put("data", todo);
		data.put("status", HttpStatus.OK);
		
		return new ResponseUtil(data, HttpStatus.OK);
	}

	@Override
	public ResponseUtil updateTodo(int id, Todo updatedTodo) {
		Optional<Todo> opt = this.listOfTodos.stream().filter(todo -> todo.getId()==id).findAny();
		Todo existingTodo = null;
		if(opt.isPresent()) existingTodo = opt.get();
		else ExceptionUtil.throwExceptionIftrue(true, "Todo Not Found");
		updatedTodo.setLastUpdatedOn(existingTodo.getLastUpdatedOn());
		existingTodo = updatedTodo;
		
		data = new HashMap<String, Object>();
		data.put("status", HttpStatus.OK);
		data.put("data", existingTodo);
		
		return new ResponseUtil(data, HttpStatus.OK);
	}

}
