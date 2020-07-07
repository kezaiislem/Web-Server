package dao;

import entity.User;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository <User,Long>{
	
	@Query("select u from User u where u.username like ?1")
	List<User> findByUsername(String username);
	
}
