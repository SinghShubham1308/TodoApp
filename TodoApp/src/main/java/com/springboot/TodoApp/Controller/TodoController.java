package com.springboot.TodoApp.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.TodoApp.Entity.Todo;
import com.springboot.TodoApp.service.TodoService;

@Controller
@SessionAttributes("username")
public class TodoController {

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	private TodoService todoService;

	@GetMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("in28minutes");
		model.addAttribute("todos", todos);

		return "listTodos";
	}
	@GetMapping("add-todo")
	public String showNewTodoPage(ModelMap map) {
		String  username = (String) map.get("username");
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		map.put("todo", todo);
		return "todo";
	}
	@PostMapping("add-todo")
	public String addNewTodoPage(ModelMap map,Todo todo) {
		String  username = (String) map.get("username");
		todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
		return "redirect:list-todos";
	}

}