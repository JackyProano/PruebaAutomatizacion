/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author marco
 */
@Entity
@Data
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long code;

    private String cardId;

    private String firstName;

    private String lastName;

    public Customer() {
    }

}
