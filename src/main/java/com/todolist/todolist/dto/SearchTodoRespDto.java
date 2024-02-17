package com.todolist.todolist.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchTodoRespDto {
	private int todoListId;
	private String todoListDate;
	private String todoListContent;
	private int todoListLike;
}
