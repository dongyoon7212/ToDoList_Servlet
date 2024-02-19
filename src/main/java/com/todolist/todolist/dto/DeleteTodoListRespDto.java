package com.todolist.todolist.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteTodoListRespDto {
	private int successCount;
}
