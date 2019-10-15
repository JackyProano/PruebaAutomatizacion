/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;

/**
 *
 * @author marco
 */
@Entity

@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})
})
@Data
public class IntelligentService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id  
    private Long code;
        
    private String name;

    
    private BigDecimal price;
   

    public IntelligentService() {
    }

    public IntelligentService(Long code) {
        this.code = code;
    }

   
}
