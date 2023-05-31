package com.example.todolist34.controller.dto;

import com.example.todolist34.domain.TodoEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoSaveRequestDto {
    private String content;
    private Boolean completed;

    @Builder
    public TodoSaveRequestDto(String content, Boolean completed) {
        this.content = content;
        this.completed = completed;
    }

    public TodoEntity toEntity() {
        return TodoEntity.builder()
                .content(this.content)
                .completed(this.completed)
                .build();
    }
}
