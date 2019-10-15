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
import org.example.spring.model.Customer;
import org.example.spring.model.CustomerDevice;
import org.example.spring.model.CustomerDeviceService;
import org.example.spring.model.CustomerDeviceService_;
import org.example.spring.model.CustomerDevice_;
import org.example.spring.model.Customer_;

import org.example.spring.model.IntelligentService_;
import org.example.spring.model.ServiceIntellegentEnum;


import org.springframework.stereotype.Service;

/**
 *
 * @author marco
 */
@Service
public class CustomerDeviceServiceRepositoryImpl implements CustomerDeviceServiceRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public void add(CustomerDeviceService customerDeviceService) {
        em.persist(customerDeviceService);

    }

    @Override
    public List<CustomerDeviceService> findByCustomerDeviceid(Long customerDeviceId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CustomerDeviceService> cq = cb.createQuery(CustomerDeviceService.class);
        Root<CustomerDeviceService> customer = cq.from(CustomerDeviceService.class);
        Predicate predicate = cb.equal(customer.get(CustomerDeviceService_.customerDevice).get(CustomerDevice_.id), customerDeviceId);
        cq.where(predicate);
        Query query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<CustomerDeviceService> findByCustomerService(String cardId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CustomerDeviceService> cq = cb.createQuery(CustomerDeviceService.class);
        Root<CustomerDeviceService> customerServiceRoot = cq.from(CustomerDeviceService.class);
        Root<CustomerDevice> customerDeviceRoot = cq.from(CustomerDevice.class);
        Root<Customer> customerRoot = cq.from(Customer.class);
        cq.select(customerServiceRoot);
        Predicate predicate = cb.equal(customerRoot.get(Customer_.cardId), cardId);
        predicate = cb.and(predicate, cb.equal(customerRoot.get(Customer_.code), customerDeviceRoot.get(CustomerDevice_.customer)));
        predicate = cb.and(predicate, cb.equal(customerDeviceRoot.get(CustomerDevice_.id), customerServiceRoot.get(CustomerDeviceService_.customerDevice)));
        cq.where(predicate);
        Query query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<CustomerDeviceService> findCustomerServiceNameService(String cardId, String name, ServiceIntellegentEnum serviceIntellegentEnum) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CustomerDeviceService> cq = cb.createQuery(CustomerDeviceService.class);
        Root<CustomerDeviceService> customerServiceRoot = cq.from(CustomerDeviceService.class);
        Root<CustomerDevice> customerDeviceRoot = cq.from(CustomerDevice.class);
        Root<Customer> customerRoot = cq.from(Customer.class);
        cq.select(customerServiceRoot);
        Predicate predicate = cb.equal(customerRoot.get(Customer_.cardId), cardId);
        predicate = cb.and(predicate, cb.equal(customerRoot.get(Customer_.code), customerDeviceRoot.get(CustomerDevice_.customer)));
        predicate = cb.and(predicate, cb.equal(customerDeviceRoot.get(CustomerDevice_.id), customerServiceRoot.get(CustomerDeviceService_.customerDevice)));
        predicate = cb.and(predicate, cb.equal(customerDeviceRoot.get(CustomerDevice_.description), name));
        predicate = cb.and(predicate, cb.equal(customerServiceRoot.get(CustomerDeviceService_.intelligentServiceCode).get(IntelligentService_.code), serviceIntellegentEnum.getCode()));
        cq.where(predicate);
        Query query = em.createQuery(cq);
        System.out.println("ANTES DEL RETURN");
        return query.getResultList();
    }

    @Override
    public void delete(CustomerDeviceService customerDeviceService) {
        em.remove(customerDeviceService);

    }
    
    
    
 }
