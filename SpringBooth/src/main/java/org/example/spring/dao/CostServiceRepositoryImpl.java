/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.example.spring.model.CostService;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marco
 */
@Repository
public class CostServiceRepositoryImpl {
    @PersistenceContext
    EntityManager em;

    
    @Transactional
    public List<CostService> findAllCostService(List<Long> codesDevice, List<Long> codeService) {
        String sql = "SELECT sum(cds.price)as cost ,cds.intelligent_service_code as service FROM public.customer_device_service cds"
                + " where cds.intelligent_service_code in (:codeService) "
                + " and cds.customer_device_id in (:codesDevice)"
                + " GROUP BY cds.intelligent_service_code";

        Query query = em.createNativeQuery(sql, CostService.class);
        query.setParameter("codesDevice", codesDevice);
        query.setParameter("codeService", codeService);
        return query.getResultList();
    }
    
}
