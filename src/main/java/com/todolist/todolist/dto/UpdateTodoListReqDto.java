package com.todolist.todolist.dto;

import com.todolist.todolist.vo.TodoListVo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateTodoListReqDto {
	private int todoListId;
	private String todoListDate;
	private String todoListContent;
	private int todoListComplete;
	
	public TodoListVo toTodo() {
		return TodoListVo.builder()
				.todoListId(todoListId)
				.todoListDate(todoListDate)
				.todoListContent(todoListContent)
				.todoListComplete(todoListComplete)
				.build();
	}
}
