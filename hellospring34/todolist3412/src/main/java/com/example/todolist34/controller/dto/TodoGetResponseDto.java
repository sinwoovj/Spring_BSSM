package com.example.todolist34.controller.dto;

import com.example.todolist34.domain.TodoEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoGetResponseDto {
    private Long id;
    private String content;
    private Boolean completed;

    @Builder
    public TodoGetResponseDto(String content, Boolean completed) {
        this.content = content;
        this.completed = completed;
    }

    public TodoGetResponseDto(TodoEntity entity) {
        this.id = entity.getId();
        this.content = entity.getContent();
        this.completed = entity.getCompleted();
    }
}
