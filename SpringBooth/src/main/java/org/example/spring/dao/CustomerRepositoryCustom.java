package org.example.spring.dao;

import org.example.spring.model.Customer;

/**
 * 
 * @author marco
 */

public interface CustomerRepositoryCustom {

    public Customer findByCarId(String cardId);

}
