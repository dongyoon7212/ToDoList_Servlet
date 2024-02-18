package com.todolist.todolist.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todolist.todolist.dto.UpdateTodoListReqDto;
import com.todolist.todolist.service.TodoListService;
import com.todolist.todolist.utils.RequestUtil;
import com.todolist.todolist.utils.ResponseEntity;

@WebServlet("/update")
public class UpdateTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TodoListService todoListService;
 
    public UpdateTodoServlet() {
        super();
        todoListService = TodoListService.getInstance();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdateTodoListReqDto reqDto = RequestUtil.convertJsonData(request, UpdateTodoListReqDto.class);
		
		ResponseEntity.ofJson(response, 201, todoListService.editTodo(reqDto));
		
		System.out.println(reqDto);
		
		System.out.println("update호출이 들어옴");
	}

}
