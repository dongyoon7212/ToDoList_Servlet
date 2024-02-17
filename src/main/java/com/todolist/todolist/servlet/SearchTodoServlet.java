package com.todolist.todolist.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todolist.todolist.service.TodoListService;
import com.todolist.todolist.utils.ResponseEntity;

@WebServlet("/todolist/getlist")
public class SearchTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TodoListService todoListService;

    public SearchTodoServlet() {
        super();
        todoListService = TodoListService.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청이 들어옴");
		
		ResponseEntity.ofJson(response, 200, todoListService.searchTodos());
	}


}
