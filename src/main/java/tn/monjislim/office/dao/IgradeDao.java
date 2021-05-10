package tn.monjislim.office.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.monjislim.office.entities.Grade;

@Repository
public interface IgradeDao extends JpaRepository<Grade, String> {
}
