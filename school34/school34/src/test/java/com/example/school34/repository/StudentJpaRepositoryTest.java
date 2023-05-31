package com.example.school34.repository;
// Ctrl + Shift + T로 생성
import com.example.school34.domain.Department;
import com.example.school34.domain.Gender;
import com.example.school34.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentJpaRepositoryTest {
    @Autowired
    private DepartmentJpaRepository departmentJpaRepository;
    @Autowired
    private StudentJpaRepository studentJpaRepository;

    @Test
    public void 값이_저장되는지(){
        //1. 학과/학생 저장
        Department department = new Department("Embeded", 32L);
        departmentJpaRepository.save(department);

        Student student = Student.builder()
                .id(1101L)
                .name("홍길동")
                .gender(Gender.MALE)
                .department(department)
                .build();
        studentJpaRepository.save(student);

        //2. 저장된 학과/학생 불러오기
        Department findDept = departmentJpaRepository.findAll().get(0);
        Student findStudent = studentJpaRepository.findAll().get(0);

        //3. 저장할 학과/학생과 저장된 학과/학생 비교
        assertEquals(findDept.getName(), "Embeded");
        assertEquals(findStudent.getId(), 1101L);
    }
}