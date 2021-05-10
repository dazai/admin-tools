package tn.monjislim.office.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.monjislim.office.entities.User;

import java.util.Optional;

@Repository
public interface IUserDao extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

    boolean existsByName(String name);

}
