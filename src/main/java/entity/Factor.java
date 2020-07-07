package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Factor implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean mtaDefault;
    @JsonIgnore
    @OneToMany(mappedBy = "factor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Section> sections;

    public Factor() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Factor(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getMtaDefault() {
        return mtaDefault;
    }

    public void setMtaDefault(boolean mtaDefault) {
        this.mtaDefault = mtaDefault;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
    
}
