package tn.monjislim.office.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.monjislim.office.entities.Student;

public interface IStudentDao extends JpaRepository<Student, Long> {
}
