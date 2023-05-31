package com.example.school34.controller.dto;

import com.example.school34.domain.Gender;
import com.example.school34.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// dto에는 다 넣는다..
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveStudentRequestDto {
    private Long id;
    private String name;
    private Gender gender;
    private Long departmentId;

    public Student toEntity() {
        return Student.builder()
            .id(this.id)
            .name(this.name)
            .gender(this.gender)
            .build();
    }
}
