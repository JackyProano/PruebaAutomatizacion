/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.service;

import org.example.spring.dao.DeviceRepositoryImpl;
import org.example.spring.model.Device;
import org.example.spring.model.DeviceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco
 */
@Service
public class DeviceService {

    @Autowired
    DeviceRepositoryImpl deviceRepositoryImpl;

    public Device getDeviceType(DeviceType deviceType) {
        return deviceRepositoryImpl.findDeviceType(deviceType);
    }
}
