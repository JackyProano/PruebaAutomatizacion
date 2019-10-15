/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;



/**
 *
 * @author marco
 */
@Data
@Entity
public class CostService {
    private BigDecimal cost;
    @Id
    private Long service;

    public CostService(BigDecimal costService, Long service) {
        this.cost = costService;
        this.service = service;
    }

    public CostService() {
    }
    
}
