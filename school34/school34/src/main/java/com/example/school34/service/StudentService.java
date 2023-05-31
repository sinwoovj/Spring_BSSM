package com.example.school34.service;

import com.example.school34.controller.dto.SaveStudentRequestDto;
import com.example.school34.domain.Department;
import com.example.school34.domain.Student;
import com.example.school34.repository.DepartmentJpaRepository;
import com.example.school34.repository.StudentJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentJpaRepository studentJpaRepository; // 서비스는 레포지터리를 부른다.
    private final DepartmentJpaRepository departmentJpaRepository;

    @Transactional
    public Long save(SaveStudentRequestDto requestDto) {
        //학생의 학번 조회
        if (studentJpaRepository.findById(requestDto.getId()).isPresent()){
            throw new IllegalArgumentException("이미 등록된 학생입니다.");
        }
        //학과 정원 확인
        Student student = requestDto.toEntity();
        Department department = departmentJpaRepository
                .findById(requestDto.getDepartmentId())
                .orElseThrow(() -> new IllegalArgumentException("해당 학과가 존재하지 않습니다."));

        changeableDept(department);
        student.chooseDept(department);

        return studentJpaRepository.save(student).getId();
    }

    private void changeableDept(Department department){
        //department의 정원과 / 학생 테이블에서 해당 학과 학생 수를 비교
        List<Student> students = studentJpaRepository.findByDept(department);
        if (department.getPersonnel() <= students.size()){
            throw new IllegalArgumentException("정원 초과 입니다.");
        }
    }
}
