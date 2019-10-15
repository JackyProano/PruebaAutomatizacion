package org.example.spring;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Produces;
import org.example.spring.dao.CustomerDeviceRepositoryImpl;
import org.example.spring.exception.CustomerException;
import org.example.spring.exception.DeviceException;
import org.example.spring.exception.ServiceException;
import org.example.spring.model.CustomerDeviceService;
import org.example.spring.service.CustomerDeviceServiceOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Clase CustomerController.java clase para ....
 * Copyright 2019 Servicio de Rentas Internas. 
 * Todos los derechos reservados
 */
/**
 *
 * @author maza261109
 */
@RestController
@RequestMapping("customerService")
public class CustomerServiceController {

    @Autowired
    private CustomerDeviceServiceOperation customerService;

    @Autowired
    CustomerDeviceRepositoryImpl customerDeviceRepositoryImpl;

    @GetMapping("/getAll/{cardId}")
    @Produces("application/jsoon")
    public ResponseEntity<List> getCustomer(@PathVariable String cardId) {
        List<CustomerDeviceService> customerDevices = customerService.getAll(cardId);
        if (!customerDevices.isEmpty()) {
            return new ResponseEntity(customerDevices, HttpStatus.OK);
        } else {
            return new ResponseEntity("No result", HttpStatus.OK);

        }

    }

    @GetMapping("/deleteService/{cardId}/{nameDevice}/{typeService}")
    @Produces("application/jsoon")
    public ResponseEntity<List> deleteService(@PathVariable String cardId, @PathVariable String nameDevice, @PathVariable String typeService) {

        try {
            customerService.delete(cardId, nameDevice, typeService);
            return new ResponseEntity("Deleted service", HttpStatus.OK);
        } catch (DeviceException | CustomerException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.OK);
        }

    }

    @GetMapping("/add/{cardId}/{name}/{typeService}")
    @Produces("application/jsoon")
    public ResponseEntity<List> addService(@PathVariable String cardId, @PathVariable String name, @PathVariable String typeService) {
        try {
            customerService.addService(cardId, name, typeService);
            return new ResponseEntity("ser creo el servicio", HttpStatus.OK);
        } catch (ServiceException | CustomerException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.OK);
        }

    }

    @GetMapping("/getCost/{cardId}")
    @Produces("application/jsoon")
    public ResponseEntity<List> getCost(@PathVariable String cardId) {
        try {
            return new ResponseEntity(customerService.getCost(cardId), HttpStatus.OK);
        } catch (ServiceException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.OK);
        }

    }
}
