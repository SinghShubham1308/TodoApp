package com.springboot.TodoApp.Controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.TodoApp.Entity.Todo;
import com.springboot.TodoApp.service.TodoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("username")
public class TodoController {
	private static Logger logger = LoggerFactory.getLogger(TodoController.class);

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	private TodoService todoService;

	@GetMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String usernameString = getLoggedInUsername(model);
		logger.debug("[TodoController][listAllTodos] username " + usernameString);
		List<Todo> todos = todoService.findByUsername(usernameString);
		logger.debug("[TodoController][listAllTodos] todos" + todos);
		model.addAttribute("todos", todos);

		return "listTodos";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	@GetMapping("add-todo")
	public String showNewTodoPage(ModelMap map) {

		String name = getLoggedInUsername(map);
		Todo todo = new Todo(0, name, "", LocalDate.now().plusYears(1), false);
		logger.debug("[TodoController][showNewTodoPage] name " + name + " map " + map + " todo " + todo);
		map.put("todo", todo);
		logger.debug("[TodoController][showNewTodoPage]  map " + map);
		logger.debug("[TodoController][showNewTodoPage] todoList " + todo);
		return "todo";
	}

	@PostMapping(value = "add-todo")
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		String username = (String) model.get("name");
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}

	@GetMapping("delete-Todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		logger.info("[TodoController][deleteTodo] into the delete method with id " + id);
		return "redirect:list-todos";
	}

	@GetMapping("update-Todo")
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {

		Todo todo = todoService.findeById(id);
		model.addAttribute("todo", todo);
//		logger.info("[TodoController][deleteTodo] into the update method with id "+id +' '+username);
		return "todo";
	}

	@PostMapping("update-Todo")
	public String UpdateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}
		logger.info("[TodoController][updateTodo] into the update method with targetdate" + todo.getTargetDate());
		String username = (String) model.get("name");
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}

}