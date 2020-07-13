package entity;

import CustomObjects.AnswerPostObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int value;
    
    private int[] chValues;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "personal_answer_id", nullable = false)
    private PersonalAnswer personalAnswer;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public Answer() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Answer(AnswerPostObject answerPost, PersonalAnswer personalAnswer) {
        this.id = answerPost.getId();
        this.value = answerPost.getValue();
        this.question = new Question(answerPost.getQuestionId());
        this.personalAnswer = personalAnswer;
        this.chValues = answerPost.getValues();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int[] getChValues() {
        return chValues;
    }

    public void setChValues(int[] chValues) {
        this.chValues = chValues;
    }

    public PersonalAnswer getPersonalAnswer() {
        return personalAnswer;
    }

    public void setPersonalAnswer(PersonalAnswer personalAnswer) {
        this.personalAnswer = personalAnswer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}
