/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.service;

import java.util.List;
import org.example.spring.dao.CustomerDeviceRepositoryImpl;
import org.example.spring.model.CustomerDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco
 */
@Service
public class CustomDeviceService {

    @Autowired
    CustomerDeviceRepositoryImpl customerDeviceRepositoryImpl;

    public List<CustomerDevice> getAllDeviceByCustomer(String cardId) {
        return customerDeviceRepositoryImpl.findByCarId(cardId);
    }
    
}
