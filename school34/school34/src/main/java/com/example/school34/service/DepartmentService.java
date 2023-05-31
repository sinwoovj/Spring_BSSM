package com.example.school34.service;

import com.example.school34.controller.dto.SaveDepartmentRequestDto;
import com.example.school34.repository.DepartmentJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service // 서비스 정의
public class DepartmentService {
    private final DepartmentJpaRepository departmentJpaRepository;

    @Transactional // 작업단위가 끝이 나면 커밋을 시켜라
    public Long save(SaveDepartmentRequestDto requestDto) {
        if (departmentJpaRepository
                .findByName(requestDto.getName()) // 저장된 이름 값 리스트
                .isPresent()){ // 이미 있다면
            throw new IllegalArgumentException("이미 등록된 학과입니다."); // 있을 시 예외 처리
        }
        return departmentJpaRepository
                .save(requestDto.toEntity())
                .getId();
    }
}
