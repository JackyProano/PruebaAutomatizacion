/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.example.spring.CostServiceVO;
import org.example.spring.dao.CostServiceRepositoryImpl;
import org.example.spring.dao.CustomerDeviceRepositoryImpl;
import org.example.spring.dao.CustomerDeviceServiceRepositoryImpl;
import org.example.spring.exception.CustomerException;
import org.example.spring.exception.DeviceException;
import org.example.spring.exception.ServiceException;
import org.example.spring.model.CostService;
import org.example.spring.model.CustomerDevice;
import org.example.spring.model.CustomerDeviceService;
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
public class CustomerDeviceServiceOperation {

    @Autowired
    CustomerDeviceServiceRepositoryImpl customDeviceService;
    @Autowired
    CustomerDeviceRepositoryImpl customerDeviceRepositoryImpl;
    @Autowired
    CostServiceRepositoryImpl costServiceRepositoryImpl;
    @Autowired
    IntelligentServiceImpl intelligentServiceImpl;
    @Autowired
    CustomerDeviceServiceRepositoryImpl customerDeviceServiceRepositoryImpl;

    public List<CustomerDeviceService> getAll(String cardId) {
        return customDeviceService.findByCustomerService(cardId);
    }

    @Transactional
    public void delete(String cardId, String nameDevice, String serviceName) throws DeviceException, CustomerException {
        if (serviceName == null || ServiceIntellegentEnum.valueOf(serviceName) == null) {
            throw new DeviceException("Bad name service name");
        }
        if (cardId.isEmpty()) {
            throw new CustomerException("device name is null");
        }

        List<CustomerDeviceService> findCustomerServiceNameService = customDeviceService.findCustomerServiceNameService(cardId, nameDevice, ServiceIntellegentEnum.valueOf(serviceName));
        findCustomerServiceNameService.stream().map((customerDeviceService) -> {
            customerDeviceService.setCustomerDevice(null);
            return customerDeviceService;
        }).forEachOrdered((customerDeviceService) -> {
            customDeviceService.delete(customerDeviceService);
        });
    }

    public List<CostServiceVO> getCost(String cardId) throws ServiceException {

        List<CustomerDevice> customerDevices = customerDeviceRepositoryImpl.findByCarId(cardId);
        List<CustomerDeviceService> customerServiceDevices = customDeviceService.findByCustomerService(cardId);
        if (customerDevices.isEmpty() || customerDevices.isEmpty()) {
            throw new ServiceException("No existen dispositivos ni equipos registrados");
        }

        List<CostService> costServices = costServiceRepositoryImpl.findAllCostService(getCodeDevices(customerDevices), getCodeServices(customerServiceDevices));

        List<CostServiceVO> costServicesVO = getCostsService(costServices);
        costServicesVO.add(getCostDevices(customerDevices));
        return costServicesVO;

    }

    private List<CostServiceVO> getCostsService(List<CostService> costServices) {
        List<CostServiceVO> costServicesVO = new ArrayList<>();
        for (CostService costService : costServices) {
            String message = "";
            if (ServiceIntellegentEnum.ANTIVIRUS_MAC.getCode().equals(costService.getService())) {
                message = message + "Costo ANTIVIRUS_MAC";
            }
            if (ServiceIntellegentEnum.ANTIVIRUS_WIN.getCode().equals(costService.getService())) {
                message = message + "Costo ANTIVIRUS_WINDOWS";
            }
            if (ServiceIntellegentEnum.CLOUDBERRY.getCode().equals(costService.getService())) {
                message = message + "Costo CLOUDBERRY";
            }
            if (ServiceIntellegentEnum.PSA.getCode().equals(costService.getService())) {
                message = message + "Costo PSA";
            }
            if (ServiceIntellegentEnum.TEAMVIEWER.getCode().equals(costService.getService())) {
                message = message + "Costo TEAMVIEWER";
            }
            costServicesVO.add(new CostServiceVO(message, costService.getCost()));
        }
        return costServicesVO;
    }

    private List<Long> getCodeDevices(List<CustomerDevice> customerDevices) {
        List<Long> codeDevices = new ArrayList<>();
        customerDevices.forEach((customerDevice) -> {
            codeDevices.add(customerDevice.getId());
        });
        return codeDevices;
    }

    private CostServiceVO getCostDevices(List<CustomerDevice> customerDevices) {
        BigDecimal costDevice = BigDecimal.ZERO;
        for (CustomerDevice customerDevice : customerDevices) {
            costDevice = costDevice.add(customerDevice.getPrice());
        }
        return new CostServiceVO("Valor total dispositivos", costDevice);
    }

    private List<Long> getCodeServices(List<CustomerDeviceService> customerServiceDevices) {
        List<Long> codeDevices = new ArrayList<>();
        customerServiceDevices.forEach((codeDevice) -> {
            codeDevices.add(codeDevice.getCode());
        });
        return codeDevices;
    }

    @Transactional
    public void addService(String cardId, String name, String typeService) throws CustomerException, ServiceException {
        List<CustomerDevice> customerDevices = customerDeviceRepositoryImpl.findByCarIdAndNameDevide(cardId, name);
        if (customerDevices.isEmpty()) {
            throw new CustomerException("No existe el customer");
        }
        if (typeService.isEmpty()) {
            throw new ServiceException("not exist type service");
        }
        IntelligentService intelligentService = intelligentServiceImpl.getIntelligentService(ServiceIntellegentEnum.valueOf(typeService));
        if (intelligentService == null) {
            throw new ServiceException("not exist type service");
        }
        CustomerDeviceService customerDeviceService = new CustomerDeviceService(intelligentService.getPrice(), customerDevices.get(0), intelligentService);
        customerDeviceServiceRepositoryImpl.add(customerDeviceService);

    }

}
