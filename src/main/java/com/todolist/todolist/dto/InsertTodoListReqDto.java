package com.todolist.todolist.dto;

import com.todolist.todolist.vo.TodoListVo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsertTodoListReqDto {
	private String todoListDate;
	private String todoListContent;
	private int todoListLike;
	
	public TodoListVo toTodo() {
		return TodoListVo.builder()
				.todoListDate(todoListDate)
				.todoListContent(todoListContent)
				.todoListLike(todoListLike)
				.build();
	}
}
