package com.todolist.todolist.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todolist.todolist.dto.InsertTodoListReqDto;
import com.todolist.todolist.service.TodoListService;
import com.todolist.todolist.utils.RequestUtil;
import com.todolist.todolist.utils.ResponseEntity;

@WebServlet("/todolist/addition")
public class InsertTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TodoListService todoListService;

    public InsertTodoServlet() {
        super();
        todoListService = TodoListService.getInstance();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InsertTodoListReqDto reqDto = RequestUtil.convertJsonData(request, InsertTodoListReqDto.class);
		
		ResponseEntity.ofJson(response, 201, todoListService.addTodo(reqDto));
		
		System.out.println(reqDto);
		
		System.out.println("요청이 들어옴!!");
	}

}
