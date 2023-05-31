package com.example.todolist34.domain;

import lombok.*;

import javax.persistence.*;

@Getter
//@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가
    private Long id;
    
    @Column(length = 200, nullable = false) //200글자 제한, NULL 비허용
    private String content;
    
    @Column(nullable = false) //NULL 비허용
    private Boolean completed;

    @Builder

    public TodoEntity(String content, Boolean completed) { // Alt+Insert -> Constructor
        this.content = content;
        this.completed = completed;
    }
}
