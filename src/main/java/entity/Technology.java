/*
 * To change this license header, choose License Headers in Technology Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import Utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author ISLEM
 */
@Entity
public class Technology {
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private long id;
    
    private String technologyName;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "field_id", nullable = false)
    private Field technologyField;

    public Technology() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public Field getTechnologyField() {
        return technologyField;
    }

    public void setTechnologyField(Field technologyField) {
        this.technologyField = technologyField;
    }
    
}
