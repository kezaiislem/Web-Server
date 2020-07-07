package dao;

import entity.Employe;
import entity.Technology;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {

    @Query("select e from Technology e where e.technologyName like ?1")
    List<Technology> findByName(String technologyName);

}
