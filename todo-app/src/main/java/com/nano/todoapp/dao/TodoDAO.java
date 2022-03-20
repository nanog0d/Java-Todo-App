package com.nano.todoapp.dao;

import java.util.List;

import com.nano.todoapp.pojo.Todo;

public interface TodoDAO {

	public List<Todo> findAll();
}
