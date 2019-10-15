/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.dao;

import java.util.List;
import org.example.spring.model.CustomerDeviceService;
import org.example.spring.model.ServiceIntellegentEnum;

/**
 *
 * @author marco
 */
public interface CustomerDeviceServiceRepositoryCustom {

    public void add(CustomerDeviceService customerDeviceService);

    public List<CustomerDeviceService> findByCustomerDeviceid(Long customerDeviceId);

    public List<CustomerDeviceService> findCustomerServiceNameService(String cardId, String name, ServiceIntellegentEnum serviceIntellegentEnum);

    public List<CustomerDeviceService> findByCustomerService(String cardId);

    public void delete(CustomerDeviceService customerDeviceService);
}
