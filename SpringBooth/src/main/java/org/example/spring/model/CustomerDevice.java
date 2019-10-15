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
public class CustomerDevice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id

    @SequenceGenerator(name = "CustomerDevice_id_seq", sequenceName = "CustomerDevice_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CustomerDevice_id_seq")
    private Long id;

    private BigDecimal price;

    private String description;

    @JoinColumn(name = "code", referencedColumnName = "code")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;

    @JoinColumn(name = "code_device", referencedColumnName = "code")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Device code;

    public CustomerDevice() {
    }

    public CustomerDevice(BigDecimal price, String description, Customer customer, Device code) {

        this.price = price;
        this.description = description;
        this.customer = customer;
        this.code = code;
    }

}
