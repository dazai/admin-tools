package tn.monjislim.office.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.monjislim.office.dto.StudentDto;
import tn.monjislim.office.entities.Student;
import tn.monjislim.office.exceptions.ResourceNotFoundException;
import tn.monjislim.office.models.RestResponse;
import tn.monjislim.office.services.IStudentService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StudentDto studentDto) {
        Student student = Student.create(studentDto);
        iStudentService.save(student);
        return ResponseEntity.ok(new RestResponse(true, "Student added successfully"));
    }

    @GetMapping("/{className}")
    public ResponseEntity<?> findByClassName(@PathVariable String className) {
        List<Student> students = iStudentService.findByClassName(className);
        Collections.sort(students);
        return ResponseEntity.ok(students);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Student> students = iStudentService.findAll();
        Collections.sort(students);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Student student = iStudentService.findById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        throw new ResourceNotFoundException("Student", "id", id);
    }

    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestBody StudentDto studentDto) {
        Student student = Student.create(studentDto);
        iStudentService.save(student);
        return ResponseEntity.ok(new RestResponse(true, "Changes saved successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        iStudentService.deleteById(id);
        return ResponseEntity.ok(new RestResponse(true, "Student deleted successfully"));
    }
}
