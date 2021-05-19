package tn.monjislim.office.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.monjislim.office.dao.IStudentDao;
import tn.monjislim.office.entities.Student;
import tn.monjislim.office.services.IStudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao iStudentDao;

    @Override
    public void save(Student student) {
        iStudentDao.save(student);
    }

    @Override
    public List<Student> findByClassName(String className) {
        return iStudentDao.findByClassName(className);
    }

    @Override
    public List<Student> findByClassNameAndGender(String className, String gender) {
        return iStudentDao.findByClassNameAndGender(className, gender);
    }

    @Override
    public List<Student> findAll() {
        return iStudentDao.findAll();
    }

    @Override
    public Student findById(Long studentId) {
        return iStudentDao.findById(studentId).orElse(null);
    }

    @Override
    public void deleteById(Long studentId) {
        iStudentDao.deleteById(studentId);
    }
}
