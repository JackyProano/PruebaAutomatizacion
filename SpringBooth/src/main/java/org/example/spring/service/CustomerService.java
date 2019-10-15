/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.service;

import org.example.spring.dao.CustomerRepositoryImpl;
import org.example.spring.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco
 */
@Service
public class CustomerService {

    @Autowired
    CustomerRepositoryImpl customerRepositoryImpl;

    public Customer getCustomerById(String cardId) {
        return customerRepositoryImpl.findByCarId(cardId);
    }

}
