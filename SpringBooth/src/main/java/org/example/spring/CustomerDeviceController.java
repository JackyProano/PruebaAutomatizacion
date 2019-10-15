package org.example.spring;

import org.example.spring.service.CustomDeviceService;
import java.util.List;

import javax.ws.rs.Produces;
import org.example.spring.exception.CustomerException;
import org.example.spring.exception.DeviceException;
import org.example.spring.model.DeviceType;
import org.example.spring.model.ServiceIntellegentEnum;
import org.example.spring.service.CustomerDeviceOperation;
import org.example.spring.service.DeviceService;
import org.example.spring.service.IntelligentServiceImpl;

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
@RequestMapping("customerDevice")
public class CustomerDeviceController {

    @Autowired
    private CustomDeviceService customerDeviceService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private IntelligentServiceImpl intelligentServiceImpl;

    @Autowired
    private CustomerDeviceOperation customerDeviceOperation;

    @GetMapping("/getAll/{cardId}")
    @Produces("application/jsoon")
    public ResponseEntity<List> getCustomer(@PathVariable String cardId) {
        return new ResponseEntity(customerDeviceService.getAllDeviceByCustomer(cardId), HttpStatus.OK);
    }

    @GetMapping("/getDevice/{typeDevice}")
    @Produces("application/jsoon")
    public ResponseEntity<List> getDeviceType(@PathVariable String typeDevice) {
        return new ResponseEntity(deviceService.getDeviceType(DeviceType.valueOf(typeDevice)), HttpStatus.OK);
    }

    @GetMapping("/getServiceIntelligent/{typeService}")
    @Produces("application/jsoon")
    public ResponseEntity<List> getServiceIntelligentType(@PathVariable String typeService) {
        return new ResponseEntity(intelligentServiceImpl.getIntelligentService(ServiceIntellegentEnum.valueOf(typeService)), HttpStatus.OK);
    }

    @GetMapping("/addDevice/{cardId}/{typeDevice}/{typeService}/{descriptionDevice}")
    @Produces("application/jsoon")
    public ResponseEntity<List> getAddDevice(@PathVariable String cardId, @PathVariable String typeDevice, @PathVariable String typeService, @PathVariable String descriptionDevice) {
        try {
            customerDeviceOperation.addDevice(cardId, typeDevice, typeService, descriptionDevice);
            return new ResponseEntity("Se ha creado", HttpStatus.OK);
        } catch (CustomerException | DeviceException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.OK);
        }

    }

    @GetMapping("/deleteDevice/{cardId}/{descriptionDevice}")
    @Produces("application/jsoon")
    public ResponseEntity<List> deleteDevice(@PathVariable String cardId, @PathVariable String descriptionDevice) {
        try {
            customerDeviceOperation.deleteDevice(cardId, descriptionDevice);
            return new ResponseEntity("Se ha borradp", HttpStatus.OK);
        } catch (DeviceException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.OK);
        }

    }

}
