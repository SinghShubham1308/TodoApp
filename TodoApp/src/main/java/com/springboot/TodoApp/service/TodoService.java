package com.springboot.TodoApp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.springboot.TodoApp.Entity.Todo;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 0;

	static {
		todos.add(new Todo(++todosCount, "SinghShubham1308", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "SinghShubham1308", "Learn DevOps", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "SinghShubham1308", "Learn Full Stack Development",
				LocalDate.now().plusYears(3), false));
		todos.add(new Todo(++todosCount, "123456", "Learn Spring Boot", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "123456", "Complete Project", LocalDate.now().plusYears(2), false));
		// Add more todos for the username "123456" as needed
	}

	public List<Todo> findByUsername(String username) {

		return todos.stream().filter(todo -> todo.getUsername().equals(username)).toList();

	}

	public void addTodo(String username, String description, LocalDate localDate, boolean isdone) {
		Todo todo = new Todo(++todosCount, username, description, localDate, isdone);
		todos.add(todo);
	}

	public void deleteTodo(int id) {
		// todo.getId() == id
		// todo -> todo.getId() == id
		Predicate<? super Todo> predicatee = todo -> todo.getId() == id;
		todos.removeIf(predicatee);
	}

	public Todo findeById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicatee = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicatee).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
	}

}
