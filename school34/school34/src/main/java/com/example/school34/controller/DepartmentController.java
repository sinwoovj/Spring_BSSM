package com.example.school34.controller;

import com.example.school34.controller.dto.SaveDepartmentRequestDto;
import com.example.school34.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor // 모든 속성에 대한 생성자를 만들 것이다. 라는 lombok
@RestController // api 기능
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/api/departments")
    public Long createDept(@RequestBody SaveDepartmentRequestDto requestDto){
        return departmentService.save(requestDto);
    }
}
