package comclass34.bssm.hellospring34.service;

import comclass34.bssm.hellospring34.domain.Student;
import comclass34.bssm.hellospring34.repository.MemoryStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Spring boot 에게 Service 임을 알림
public class StudentService {
    private final MemoryStudentRepository repository;

    @Autowired // 자동으로 연결됨을 알림
    public StudentService(MemoryStudentRepository repository) {
        this.repository = repository;
    }

    //학생 등록
    public Long edit(Student student){
        //1. 학번이 중복되는지?
        validateDuplicateStudent(student);

        //2. 학생 등록
        Student saveStudent = repository.save(student);
        System.out.println((saveStudent.getId()));
        System.out.println((saveStudent.getName()));
        return saveStudent.getId();
    }

    private void validateDuplicateStudent(Student student) {
        //학번이 중복된다.
        if (repository.findeById(student.getId()) != null){ //하나의 값을 찾는다.
            throw new IllegalStateException("이미 존재하는 학번입니다.");
        }
    }

    public List<Student> findStudents() {
        return repository.findAll();
    }

    public Student findOne(Long id) {
        return repository.findeById(id);
    }

    public void updateStudent(Student updateStudent) {
        //1. store에서 student 하나를 찾아옴(updateStudent.getId)
        Student update = repository.findeById(updateStudent.getId());
        //2. 찾아온 거에 score를 바꾼다.
        update.setScore(updateStudent.getScore());
        //끝
    }
}
