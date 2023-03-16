package com.frontBackApp.studentSystem.service;

import com.frontBackApp.studentSystem.exception.StudentNotFoundException;
import com.frontBackApp.studentSystem.model.Student;
import com.frontBackApp.studentSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public Student updateStudentDetails(Student newStudent, Integer id) {
      return studentRepository.findById(id)
              .map(student -> {
                  student.setName(newStudent.getName());
                  student.setAddress(newStudent.getAddress());
                  return studentRepository.save(student);
              }).orElseThrow(() -> new StudentNotFoundException(id));
    }


    public String deleteStudent(Integer id) {
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
        return "Student with id "+id+" has been deleted successfully";
    }
}
