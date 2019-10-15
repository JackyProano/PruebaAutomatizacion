/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author marco
 */
@Data
@AllArgsConstructor
public class CostServiceVO {
    private String descriptionService;
    private BigDecimal cost;
}
