/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.example.spring.model.Customer;
import org.example.spring.model.Customer_;

import org.springframework.stereotype.Service;

/**
 *
 * @author marco
 */
@Service
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public Customer findByCarId(String cardId) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);

            Root<Customer> customer = cq.from(Customer.class);
            Predicate predicate = cb.equal(customer.get(Customer_.cardId), cardId);

            cq.where(predicate);

            Query query = em.createQuery(cq);

            return (Customer) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }

    }

}
