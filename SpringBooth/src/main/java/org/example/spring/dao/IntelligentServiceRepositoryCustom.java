/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.dao;

import java.util.List;
import org.example.spring.model.IntelligentService;
import org.example.spring.model.ServiceIntellegentEnum;

/**
 *
 * @author marco
 */
public interface IntelligentServiceRepositoryCustom {
    public IntelligentService findByTypeService(ServiceIntellegentEnum intellegentEnum);
    public List<IntelligentService> getAll();
    
}
