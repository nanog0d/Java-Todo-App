package com.nano.todoapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nano.todoapp.pojo.Todo;

@Repository
public class DefaultTodoDAO implements TodoDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Todo> findAll() {
		Session currSession = entityManager.unwrap(Session.class);
		Query query = currSession.createQuery("from Todo", Todo.class);
		@SuppressWarnings("unchecked")
		List<Todo> listOfTodos = (List<Todo>) query.getResultList();
		return listOfTodos;
	}

}
