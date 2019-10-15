/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.dao;

import org.example.spring.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author marco
 */

public interface CustomerRepository extends JpaRepository<Customer, Long>,CustomerRepositoryCustom {
    
}
