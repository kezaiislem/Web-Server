package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Survey implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int phaseNumber;
    private String title;
    private String description;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Factor> factors;
    
    @JsonIgnore
    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<PersonalAnswer> personalAnswers;
    
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "host_id", referencedColumnName = "id")
    private Host host;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(optional = false)
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;
    
    public Survey() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Survey(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { 
        this.id = id;
    }

    public int getPhaseNumber() {
        return phaseNumber;
    }

    public void setPhaseNumber(int phaseNumber) {
        this.phaseNumber = phaseNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Factor> getFactors() {
        return factors;
    }

    public void setFactors(List<Factor> factors) {
        this.factors = factors;
    }

    public List<PersonalAnswer> getPersonalAnswers() {
        return personalAnswers;
    }

    public void setPersonalAnswers(List<PersonalAnswer> personalAnswers) {
        this.personalAnswers = personalAnswers;
    }
    
    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

}
