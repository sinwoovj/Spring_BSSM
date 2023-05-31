package com.example.school34.controller.dto;

import com.example.school34.domain.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter랑 setter 합친거
@AllArgsConstructor
@NoArgsConstructor
public class SaveDepartmentRequestDto {
    private String name;
    private Long personnel;

    public Department toEntity() {
        return new Department(name, personnel);
    }
}
