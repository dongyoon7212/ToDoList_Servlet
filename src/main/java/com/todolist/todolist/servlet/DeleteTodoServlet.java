package com.todolist.todolist.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todolist.todolist.dto.DeleteTodoListReqDto;
import com.todolist.todolist.service.TodoListService;
import com.todolist.todolist.utils.RequestUtil;
import com.todolist.todolist.utils.ResponseEntity;

@WebServlet("/delete")
public class DeleteTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TodoListService todoListService;
	
    public DeleteTodoServlet() {
        super();
        todoListService = TodoListService.getInstance();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeleteTodoListReqDto reqDto = RequestUtil.convertJsonData(request, DeleteTodoListReqDto.class);
		System.out.println(reqDto);
		
		ResponseEntity.ofJson(response, 201, todoListService.removeTodo(reqDto));
	}

}
