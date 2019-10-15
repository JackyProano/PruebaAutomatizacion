/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import lombok.Data;

/**
 *
 * @author marco
 */
@Entity
@Data
public class CustomerDeviceService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id

    @SequenceGenerator(name = "CustomerDeviceService_code_seq", sequenceName = "CustomerDeviceService_code_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CustomerDeviceService_code_seq")

    private Long code;

    private BigDecimal price;

    @JoinColumn(name = "customer_device_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private CustomerDevice customerDevice;

    @JoinColumn(name = "intelligentServiceCode", referencedColumnName = "code")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private IntelligentService intelligentServiceCode;

    public CustomerDeviceService() {
    }

    public CustomerDeviceService(BigDecimal price, CustomerDevice customerDevice, IntelligentService intelligentService) {

        this.price = price;
        this.customerDevice = customerDevice;
        this.intelligentServiceCode = intelligentService;
    }

}
