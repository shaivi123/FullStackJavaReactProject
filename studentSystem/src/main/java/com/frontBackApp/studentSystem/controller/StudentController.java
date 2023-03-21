package com.frontBackApp.studentSystem.controller;

import com.frontBackApp.studentSystem.dto.StudentDto;
import com.frontBackApp.studentSystem.exception.StudentNotFoundException;
import com.frontBackApp.studentSystem.model.Student;
import com.frontBackApp.studentSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public String saveStudent(@RequestBody Student student) throws Exception {
        studentService.saveStudent(student.getName(), student.getAddress());
        return "New student added!";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Integer id ){
        return studentService.getStudentById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PutMapping("/student/{id}")
    public Student updateStudentDetails(@RequestBody Student newStudent, @PathVariable Integer id){
        return studentService.updateStudentDetails(newStudent, id);

    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }
}
