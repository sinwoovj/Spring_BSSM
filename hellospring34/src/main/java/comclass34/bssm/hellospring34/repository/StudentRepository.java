package comclass34.bssm.hellospring34.repository;

import comclass34.bssm.hellospring34.domain.Student;

import java.util.List;

public interface StudentRepository {
    Student save(Student student);
//    findById
    Student findeById(Long id);

    List<Student> findAll();

//    findAll
}
