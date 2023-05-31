package comclass34.bssm.hellospring34.controller;

import comclass34.bssm.hellospring34.domain.Student;
import comclass34.bssm.hellospring34.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students/new")
    public String createForm(){
        return "students/createStudentForm";
    }

    @PostMapping("/students/new")
    public String create(StudentForm form){
        Student student = new Student();
        student.setId(form.getId());
        student.setName(form.getName());
        //학생 저장
        service.edit(student);
        return "redirect:/";
    }

    //학생 리스트 확인
    @GetMapping("/students")
    public String studentList(Model model){
        //학생 리스트 데이터
        List<Student> list = service.findStudents();
        model.addAttribute("students",list);
        return "students/studentList";
    }

    @GetMapping("/students/{id}/input")
    public String updateForm(@PathVariable("id") Long id,
                             Model model){
        Student student = service.findOne(id);
        model.addAttribute("form", student); //받을 때의 변수 이름, 보낼 데이터
        return "students/updateStudentsForm";
    }

    @PostMapping("/students/{id}/input")
    public String updateScore(@PathVariable("id") Long id,
                              @ModelAttribute("form") Student form) {
        // update data
        Student updateStudent = new Student();
        updateStudent.setId(form.getId());
        updateStudent.setName(form.getName());
        updateStudent.setScore(form.getScore());

        service.updateStudent(updateStudent);

        return "redirect:/students";
    }
}
