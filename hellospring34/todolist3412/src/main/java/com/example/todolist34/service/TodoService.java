package com.example.todolist34.service;

import com.example.todolist34.controller.dto.TodoGetResponseDto;
import com.example.todolist34.controller.dto.TodoSaveRequestDto;
import com.example.todolist34.domain.TodoEntity;
import com.example.todolist34.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public Long save(TodoSaveRequestDto requestDto) {
        return todoRepository.save(requestDto.toEntity()).getId();
    }

    public List<TodoGetResponseDto> findAll() {
        List<TodoEntity> all = todoRepository.findAll();
        List<TodoGetResponseDto> result = new ArrayList<>();
        for (TodoEntity todoEntity : all) {
            result.add(new TodoGetResponseDto(todoEntity));
        }
        return result;
    }

    public void deleteAll(){
        todoRepository.deleteAll();
    }

    public TodoEntity findById(Long id) {
        return todoRepository.findById(id).orElse(new TodoEntity());
    }

    public void deleteOne(Long id) {
        todoRepository.deleteById(id);
    }

    @Transactional
    public Long updateData(Long id, TodoSaveRequestDto requestDto) {
        //entity 가져오기
        TodoEntity todoEntity = todoRepository.findById(id).orElse(new TodoEntity());
        //값 교체
        todoEntity.update(requestDto.getContent(), requestDto.getCompleted());

        return todoEntity.getId();
    }
}
