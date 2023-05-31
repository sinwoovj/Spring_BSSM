package comclass34.bssm.hellospring34.repository;

import comclass34.bssm.hellospring34.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryStudentRepository implements StudentRepository{
    private static Map<Long, Student> store = new HashMap<>();

    @Override
    public Student save(Student student) {
        store.put(student.getId(), student);
        return store.get(student.getId());
    }

    @Override
    public Student findeById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>(store.values());
        return list;
    }
}