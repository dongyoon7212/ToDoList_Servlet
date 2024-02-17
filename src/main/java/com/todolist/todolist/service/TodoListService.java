package com.todolist.todolist.service;

import com.todolist.todolist.dao.TodoListDao;
import com.todolist.todolist.dto.InsertTodoListReqDto;
import com.todolist.todolist.dto.InsertTodoListRespDto;
import com.todolist.todolist.vo.TodoListVo;

public class TodoListService {
	private static TodoListService instance;
	private TodoListDao todoListDao;
	
	private TodoListService() {
		todoListDao = TodoListDao.getInstance();
	}
	
	public static TodoListService getInstance() {
		if( instance == null ) {
			instance = new TodoListService();
		}
		
		return instance;
	}
	
	public InsertTodoListRespDto addTodo(InsertTodoListReqDto insertTodoListReqDto) {
		TodoListVo todoListVo = insertTodoListReqDto.toTodo();
		
		int successCount = todoListDao.saveTodo(todoListVo);
		
		return todoListVo.toInsertDto(successCount);
	}
}
