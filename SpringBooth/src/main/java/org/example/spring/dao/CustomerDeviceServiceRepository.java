/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.dao;



import org.example.spring.model.CustomerDeviceService;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author marco
 */
public interface  CustomerDeviceServiceRepository extends JpaRepository<CustomerDeviceService, Long>,CustomerDeviceServiceRepositoryCustom{
    
}
