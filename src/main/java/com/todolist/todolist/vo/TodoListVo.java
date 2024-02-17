package com.todolist.todolist.vo;

import com.todolist.todolist.dto.InsertTodoListRespDto;
import com.todolist.todolist.dto.SearchTodoRespDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoListVo {
	private int todoListId;
	private String todoListDate;
	private String todoListContent;
	private int todoListLike;

	public InsertTodoListRespDto toInsertDto(int successCount) {
		return InsertTodoListRespDto.builder()
				.successCount(successCount)
				.todoListId(todoListId)
				.todoListDate(todoListDate)
				.todoListContent(todoListContent)
				.todoListLike(todoListLike)
				.build();
	}
	
	public SearchTodoRespDto toSearchDto() {
		return SearchTodoRespDto.builder()
				.todoListId(todoListId)
				.todoListDate(todoListDate)
				.todoListContent(todoListContent)
				.todoListLike(todoListLike)
				.build();
	}
}
