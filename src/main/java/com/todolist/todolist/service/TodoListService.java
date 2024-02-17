package com.todolist.todolist.service;

import java.util.ArrayList;
import java.util.List;

import com.todolist.todolist.dao.TodoListDao;
import com.todolist.todolist.dto.InsertTodoListReqDto;
import com.todolist.todolist.dto.InsertTodoListRespDto;
import com.todolist.todolist.dto.SearchTodoRespDto;
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
	
	public List<SearchTodoRespDto> searchTodos() {
		List<SearchTodoRespDto> searchTodoRespDtos = new ArrayList<>();
		
		List<TodoListVo> todoListVos = todoListDao.getTodoList();
		
		for(TodoListVo todoListVo : todoListVos) {
			searchTodoRespDtos.add(todoListVo.toSearchDto());
		}
		
		return searchTodoRespDtos;
	}
}
