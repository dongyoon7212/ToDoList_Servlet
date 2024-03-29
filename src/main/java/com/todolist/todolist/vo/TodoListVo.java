package com.todolist.todolist.vo;

import com.todolist.todolist.dto.CompleteDeleteTodoListRespDto;
import com.todolist.todolist.dto.DeleteTodoListRespDto;
import com.todolist.todolist.dto.InsertTodoListRespDto;
import com.todolist.todolist.dto.SearchTodoRespDto;
import com.todolist.todolist.dto.UpdateTodoListRespDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoListVo {
	private int todoListId;
	private String todoListDate;
	private String todoListContent;
	private int todoListComplete;

	public InsertTodoListRespDto toInsertDto(int successCount) {
		return InsertTodoListRespDto.builder()
				.successCount(successCount)
				.todoListId(todoListId)
				.todoListDate(todoListDate)
				.todoListContent(todoListContent)
				.todoListComplete(todoListComplete)
				.build();
	}
	
	public SearchTodoRespDto toSearchDto() {
		return SearchTodoRespDto.builder()
				.todoListId(todoListId)
				.todoListDate(todoListDate)
				.todoListContent(todoListContent)
				.todoListComplete(todoListComplete)
				.build();
	}
	
	public UpdateTodoListRespDto toUpdateDto(int successCount) {
		return UpdateTodoListRespDto.builder()
				.successCount(successCount)
				.todoListId(todoListId)
				.todoListDate(todoListDate)
				.todoListContent(todoListContent)
				.todoListComplete(todoListComplete)
				.build();
	}
	
	public DeleteTodoListRespDto toDeleteDto(int successCount) {
		return DeleteTodoListRespDto.builder()
				.successCount(successCount)
				.build();
	}
	
	public CompleteDeleteTodoListRespDto toDeleteAllDto(int sccessCount) {
		return CompleteDeleteTodoListRespDto.builder()
				.successCount(sccessCount)
				.build();
	}
}
