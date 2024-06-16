package com.springboot.TodoApp.Controller;

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
import com.springboot.TodoApp.Entity.TodoRepository;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("username")
public class TodoControllerJPA {

    private static Logger logger = LoggerFactory.getLogger(TodoControllerJPA.class);
    private TodoRepository todoRepository;

    public TodoControllerJPA( TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        String usernameString = getLoggedInUsername(model);
        logger.debug("[TodoController][listAllTodos] username " + usernameString);
        List<Todo> todos = todoRepository.findByUsername(usernameString);
        logger.debug("[TodoController][listAllTodos] todos" + todos);
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    private String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @GetMapping("add-todo")
    public String showNewTodoPage(ModelMap map){
        String name = getLoggedInUsername(map);
        Todo todo = new Todo();
        todo.setUsername(name);
        todo.setTargetDate(todo.getTargetDate());
        map.put("todo", todo);
        return "todo";
    }

    @PostMapping(value = "add-todo")
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        logger.debug("------------addnewtodo--------" + todo);
        return "redirect:list-todos";
    }

    @GetMapping("delete-Todo")
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        logger.info("[TodoController][deleteTodo] into the delete method with id " + id);
        return "redirect:list-todos";
    }

    @GetMapping("update-Todo")
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "todo";
    }
    

    @PostMapping("update-Todo")
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }
}
