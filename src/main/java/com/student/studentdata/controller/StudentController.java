package com.student.studentdata.controller;

import com.student.studentdata.dto.StudentDto;
import com.student.studentdata.entity.StudentEntity;
import com.student.studentdata.repository.StudentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepo studentRepo;

    @GetMapping("/getStudentDetails")
    public List<StudentEntity> getStudentName() {
        List<StudentEntity> studentEntityList = new ArrayList<>();
        for (StudentEntity student : studentRepo.findAll()) {
            if (student.getState().equals("Kerala") || student.getState().equals("Tamil Nadu")) {
                studentEntityList.add(student);
            }
        }
        return studentEntityList;
    }

    @GetMapping("/getStudentDetailsUsingStream")
    public List<StudentEntity> getStudentDetailsUsingStream() {
        return studentRepo.findAll().stream().filter(student -> "Kerala".contains(student.getState()) || student.getName().contains("A")).toList();
    }

    @Transactional
    @PostMapping("/saveNewStudent")
    public StudentEntity saveNewStudent(@RequestBody StudentDto studentDto) {
        StudentEntity student = new StudentEntity();
        student.setName(Optional.ofNullable(studentDto.getName()).orElse(""));
        student.setAddress(Optional.ofNullable(studentDto.getAddress()).orElse(""));
        student.setState(Optional.ofNullable(studentDto.getState()).orElse(""));
        student.setCountry(Optional.ofNullable(studentDto.getCountry()).orElse(""));
        return studentRepo.save(student);
    }

    @GetMapping("/findStudentStatus")
    public Optional<StudentEntity> findStudentStatus(@RequestParam Long id) {
        return studentRepo.findById(id);
    }


}
