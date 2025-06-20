package org.example.spring;

import java.util.List;

import javax.ws.rs.Produces;
import org.example.spring.service.CustomerService;
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
@RequestMapping("api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/people/{cardId}")
    @Produces("application/jsoon")
    public ResponseEntity<List> getCustomer(@PathVariable String cardId) {
        return new ResponseEntity(customerService.getCustomerById(cardId), HttpStatus.OK);
        //return new ResponseEntity("PRUEBA-AUTOMATIZACION", HttpStatus.OK);
    }

//    @RequestMapping("/deletePeople")
//    @ResponseBody
//    public void deletePeople() {
//        personService.deletePeople(1);
//    }
}
