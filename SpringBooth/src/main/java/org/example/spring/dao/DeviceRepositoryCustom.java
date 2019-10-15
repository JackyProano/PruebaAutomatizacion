/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.dao;

import org.example.spring.model.Device;
import org.example.spring.model.DeviceType;


/**
 *
 * @author marco
 */
public interface DeviceRepositoryCustom {
     public Device findDeviceType(DeviceType deviceType);
}
