/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.dao;

import java.util.List;
import org.example.spring.model.CustomerDevice;

/**
 *
 * @author marco
 */
public interface CustomerDeviceRepositoryCustom {

    public List<CustomerDevice> findByCarId(String cardId);

    public List<CustomerDevice> findByCarIdAndNameDevide(String cardId, String name);

    public void delete(CustomerDevice customerDevice);
}
