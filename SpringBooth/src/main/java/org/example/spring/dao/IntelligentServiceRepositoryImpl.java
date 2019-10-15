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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.example.spring.model.IntelligentService;
import org.example.spring.model.IntelligentService_;
import org.example.spring.model.ServiceIntellegentEnum;
import org.springframework.stereotype.Service;


/**
 *
 * @author marco
 */
@Service
public class IntelligentServiceRepositoryImpl implements IntelligentServiceRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public IntelligentService findByTypeService(ServiceIntellegentEnum intellegentEnum) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<IntelligentService> cq = cb.createQuery(IntelligentService.class);
        Root<IntelligentService> customer = cq.from(IntelligentService.class);
        Predicate predicate = cb.equal(customer.get(IntelligentService_.code), intellegentEnum.getCode());
        cq.where(predicate);
        Query query = em.createQuery(cq);
        return (IntelligentService) query.getSingleResult();
    }

    public List<IntelligentService> getAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<IntelligentService> cq = cb.createQuery(IntelligentService.class);
        Root<IntelligentService> customer = cq.from(IntelligentService.class);
        cq.select(customer);
        Query query = em.createQuery(cq);
        return query.getResultList();
    }
}
