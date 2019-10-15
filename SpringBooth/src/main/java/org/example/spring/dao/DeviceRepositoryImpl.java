/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.example.spring.model.Device;
import org.example.spring.model.DeviceType;
import org.example.spring.model.Device_;


import org.springframework.stereotype.Service;

/**
 *
 * @author marco
 */
@Service
public class DeviceRepositoryImpl implements DeviceRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public Device findDeviceType(DeviceType deviceType) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Device> cq = cb.createQuery(Device.class);
        Root<Device> customer = cq.from(Device.class);
        Predicate predicate = cb.equal(customer.get(Device_.deviceType), deviceType);
        cq.where(predicate);
        Query query = em.createQuery(cq);
        return (Device) query.getSingleResult();
    }

}
