package com.todolist.todolist.dto;

import com.todolist.todolist.vo.TodoListVo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteTodoListReqDto {
	private int todoListId;
	
	public TodoListVo toTodo() {
		return TodoListVo.builder()
				.todoListId(todoListId)
				.build();
	}
}
