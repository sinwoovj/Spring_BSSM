package com.example.todolist34.repository;

import com.example.todolist34.domain.TodoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoRepositoryTest {
    @Autowired
    TodoRepository todoRepository;

    @Test
    public void 저장되는지(){
        //값 저장
        TodoEntity entity = TodoEntity.builder()
                .content("a content")
                .completed(false)
                .build();
        todoRepository.save(entity);
        //저장된 값 들고 오기
        List<TodoEntity> all = todoRepository.findAll();
        //저장할 값과 저장된 값 비교햐기
        assertEquals(all.get(0).getContent(), "a content");

    }
}