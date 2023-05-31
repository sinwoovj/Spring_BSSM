package com.example.todolist34.controller;

import com.example.todolist34.controller.dto.TodoGetResponseDto;
import com.example.todolist34.controller.dto.TodoSaveRequestDto;
import com.example.todolist34.domain.TodoEntity;
import com.example.todolist34.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/todo/api")
    public Long saveTodo(@RequestBody TodoSaveRequestDto requestDto) {
        return todoService.save(requestDto);
    }

    @GetMapping("/todo/api/{id}")
    public TodoGetResponseDto findOne(@PathVariable("id") Long id) {
        TodoEntity entity = todoService.findById(id);
//        return TodoGetResponseDto.builder()
//                .content(entity.getContent())
//                .completed(entity.getCompleted())
//                .build();
        return new TodoGetResponseDto(entity);
    }

    @GetMapping("/todo/api")
    public List<TodoGetResponseDto> findALL(){
        return todoService.findAll();
    }
//    public void findAllTodo() {
//        List<TodoEntity> all = todoService.findAll();
//
//    }
    @DeleteMapping("/todo/api")
    public void deleteAll() {
        todoService.deleteAll();
    }

    @DeleteMapping("/todo/api/{id}")
    public void deleteOne(@PathVariable Long id) {
        todoService.deleteOne(id);
    }

    //id가 포함된 post
    @PutMapping("/todo/api/{id}")
    public Long update(@PathVariable Long id, @RequestBody TodoSaveRequestDto requestDto){
        return todoService.updateData(id, requestDto);
    }
}
