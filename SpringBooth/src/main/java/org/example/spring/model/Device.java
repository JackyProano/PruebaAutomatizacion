/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author marco
 */
@Entity
@Data
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "code")
    private Long code;
    
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;
    
    
    private BigDecimal price;
  

    public Device() {
    }

    public Device(Long code) {
        this.code = code;
    }

}
