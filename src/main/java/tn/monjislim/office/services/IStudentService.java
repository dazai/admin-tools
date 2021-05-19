package tn.monjislim.office.services;

import tn.monjislim.office.entities.Student;

import java.util.List;

public interface IStudentService {

    void save (Student student);

    List<Student> findAll();

    List<Student> findByClassName(String className);

    List<Student> findByClassNameAndGender(String className, String gender);

    Student findById(Long studentId);

    void deleteById(Long studentId);
}
