package tn.monjislim.office.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.monjislim.office.entities.Grade;

import java.util.List;
import java.util.Optional;

@Repository
public interface IGradeDao extends JpaRepository<Grade, String> {

    List<Grade> findByLevel(Integer level);

}
