package dao;

import entity.Answer;
import entity.PersonalAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalAnswerRepository extends JpaRepository<PersonalAnswer, Long> {

}
