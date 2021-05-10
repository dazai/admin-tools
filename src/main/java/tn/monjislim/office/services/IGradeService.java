package tn.monjislim.office.services;

import tn.monjislim.office.entities.Grade;

import java.util.List;

public interface IGradeService {

    void addGrade (Grade grade);

    Grade findById(String gradeId);

    List<Grade> findByLevel(Integer level);

    List<Grade> findAll();

    void deleteById(String gradeId);

}
