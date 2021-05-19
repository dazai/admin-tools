package tn.monjislim.office.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.monjislim.office.entities.Student;

import java.util.List;

public interface IStudentDao extends JpaRepository<Student, Long> {

    List<Student> findByClassName(String className);

    List<Student> findByClassNameAndGender(String className, String gender);
}
