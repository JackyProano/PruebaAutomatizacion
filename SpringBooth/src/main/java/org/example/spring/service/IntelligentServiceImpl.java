/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.service;

import org.example.spring.dao.IntelligentServiceRepositoryImpl;
import org.example.spring.model.IntelligentService;
import org.example.spring.model.ServiceIntellegentEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco
 */
@Service
public class IntelligentServiceImpl {
    @Autowired
    IntelligentServiceRepositoryImpl intelligentServiceRepositoryImpl;
    
    public IntelligentService getIntelligentService(ServiceIntellegentEnum serviceIntellegentEnum){
            return intelligentServiceRepositoryImpl.findByTypeService(serviceIntellegentEnum);
    }
}
