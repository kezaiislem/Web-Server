package dao;

import entity.Employe;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository <Employe,Long>{
	
	@Query("select e from Employe e where e.nom like %?1% or e.prenom like %?1%")
	List<Employe> findByName(String nom);
	
}
