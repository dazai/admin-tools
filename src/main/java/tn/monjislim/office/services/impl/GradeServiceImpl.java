package tn.monjislim.office.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.monjislim.office.dao.IGradeDao;
import tn.monjislim.office.entities.Grade;
import tn.monjislim.office.exceptions.ResourceNotFoundException;
import tn.monjislim.office.services.IGradeService;

import java.util.List;

@Service
public class GradeServiceImpl implements IGradeService {

    @Autowired
    private IGradeDao iGradeDao;

    @Override
    public void addGrade(Grade grade) {
        iGradeDao.save(grade);
    }

    @Override
    public Grade findById(String gradeId) {
        return iGradeDao.findById(gradeId).orElseThrow(() -> new ResourceNotFoundException("Grade", "id", gradeId));
    }

    @Override
    public List<Grade> findByLevel(Integer level) {
        return iGradeDao.findByLevel(level);
    }

    @Override
    public List<Grade> findAll() {
        return iGradeDao.findAll();
    }

    @Override
    public void deleteById(String gradeId) {
        iGradeDao.deleteById(gradeId);
    }
}
