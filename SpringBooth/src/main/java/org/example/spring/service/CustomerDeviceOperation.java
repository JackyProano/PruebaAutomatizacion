/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.service;

import java.util.List;
import org.example.spring.dao.CustomerDeviceRepositoryImpl;
import org.example.spring.dao.CustomerDeviceServiceRepositoryImpl;
import org.example.spring.dao.CustomerRepositoryImpl;
import org.example.spring.dao.DeviceRepositoryImpl;
import org.example.spring.exception.CustomerException;
import org.example.spring.exception.DeviceException;
import org.example.spring.model.Customer;
import org.example.spring.model.CustomerDevice;
import org.example.spring.model.CustomerDeviceService;
import org.example.spring.model.Device;
import org.example.spring.model.DeviceType;
import org.example.spring.model.IntelligentService;
import org.example.spring.model.ServiceIntellegentEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marco
 */
@Service
public class CustomerDeviceOperation {

    @Autowired
    CustomerRepositoryImpl customerRepositoryImpl;

    @Autowired
    DeviceRepositoryImpl deviceRepositoryImpl;

    @Autowired
    IntelligentServiceImpl intelligentServiceImpl;

    @Autowired
    CustomerDeviceServiceRepositoryImpl customerDeviceServiceRepositoryImpl;

    @Autowired
    CustomerDeviceRepositoryImpl customerDeviceRepositoryImpl;

    @Transactional
    public void addDevice(String cardId, String typeDevice, String typeService, String descriptionDevice) throws CustomerException, DeviceException {
        Customer customer = (Customer) customerRepositoryImpl.findByCarId(cardId);
        if (customer == null) {
            throw new CustomerException("Customer no exist " + cardId);
        }

        if (typeDevice == null || DeviceType.valueOf(typeDevice) == null) {
            throw new DeviceException("Device type no exist " + typeDevice);
        }
        Device device = deviceRepositoryImpl.findDeviceType(DeviceType.valueOf(typeDevice));

        if (typeService == null || ServiceIntellegentEnum.valueOf(typeService) == null) {
            throw new DeviceException("Service type no exist " + typeDevice);
        }
        IntelligentService intelligentService = intelligentServiceImpl.getIntelligentService(ServiceIntellegentEnum.valueOf(typeService));
        
        CustomerDevice customerDevice = new CustomerDevice(device.getPrice(), descriptionDevice, customer, device);
        CustomerDeviceService customerDeviceService = new CustomerDeviceService(intelligentService.getPrice(), customerDevice, intelligentService);
        customerDeviceServiceRepositoryImpl.add(customerDeviceService);

    }

    @Transactional
    public void deleteDevice(String cardId, String descriptionDevice) throws DeviceException {
        List<CustomerDevice> customerDevices = customerDeviceRepositoryImpl.findByCarIdAndNameDevide(cardId, descriptionDevice);
        if (customerDevices.isEmpty()) {
            throw new DeviceException("No exist device ");
        }
        if (customerDevices.size() > 1) {
            throw new DeviceException("Exist mor than one device ");
        }

        List<CustomerDeviceService> services = customerDeviceServiceRepositoryImpl.findByCustomerDeviceid(customerDevices.get(0).getId());
        if (!services.isEmpty()) {
            services.stream().map((service) -> {
                service.setCustomerDevice(customerDevices.get(0));
                return service;
            }).forEachOrdered((service) -> {
                customerDeviceServiceRepositoryImpl.delete(service);
            });
        } else {
            customerDeviceRepositoryImpl.delete(customerDevices.get(0));
        }
    }

}
