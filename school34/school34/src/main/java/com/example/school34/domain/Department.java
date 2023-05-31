package com.example.school34.domain;
// 파일 위치

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본생성자를 항상 가지고 가게끔
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 값 증가
    private Long id;

    @Column(nullable = false) // null값 방지 속성
    private String name;

    @Column(nullable = false)
    private Long personnel;

    // Alt + insert >> constructor >> id 뺴고 생성
    public Department(String name, Long personnel) {
        this.name = name;
        this.personnel = personnel;
    }
}
