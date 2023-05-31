package com.example.school34.domain;
// 파일 위치

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Student{
    @Id // primary key
    private Long id;

    @Column(nullable = false) // null 값 안됨
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // 숫자가 아니라 FEMALE, MALE 과 같은 String을 받음
    private Gender gender;

    // @Column(nullable = false) << 외래키의 참조 무결성 법칙 때문에 안됨 -> 외래키는 null거나 참조된 값
    @ManyToOne // 자신이 1 대 n 관계에서 n임을 정의
    private Department department;

    @Builder
    public Student(Long id, String name, Gender gender, Department department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
    }

    public void chooseDept(Department department) { //department에 대한 setter와 같음
        this.department = department;
    }
}

//https://bssmmrchoi.notion.site/04e31a1dc1f3434cbe5212db52bf2e26
