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
import org.example.spring.model.CustomerDevice;
import org.example.spring.model.CustomerDevice_;
import org.example.spring.model.Customer_;

import org.springframework.stereotype.Service;


/**
 *
 * @author marco
 */
@Service
public class CustomerDeviceRepositoryImpl implements CustomerDeviceRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<CustomerDevice> findByCarId(String cardId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CustomerDevice> cq = cb.createQuery(CustomerDevice.class);
        Root<CustomerDevice> customer = cq.from(CustomerDevice.class);
        Predicate predicate = cb.equal(customer.get(CustomerDevice_.customer).get(Customer_.CARD_ID), cardId);
        cq.where(predicate);
        Query query = em.createQuery(cq);
        return query.getResultList();

    }

    @Override
    public List<CustomerDevice> findByCarIdAndNameDevide(String cardId, String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CustomerDevice> cq = cb.createQuery(CustomerDevice.class);
        Root<CustomerDevice> customerDevice = cq.from(CustomerDevice.class);
      
        Predicate predicate = cb.equal(customerDevice.get(CustomerDevice_.customer).get(Customer_.cardId), cardId);
        predicate =cb.and(predicate,cb.equal(customerDevice.get(CustomerDevice_.description), name));
       
        cq.where(predicate);
        Query query = em.createQuery(cq);
        return query.getResultList();

    }
    
    @Override
    public void delete(CustomerDevice customerDevice){
        em.remove(customerDevice);
    }
}
