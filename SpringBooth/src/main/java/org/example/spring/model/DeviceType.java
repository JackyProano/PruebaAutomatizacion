/*
 * Clase DeviceType.java clase para ....
 * Copyright 2019 Servicio de Rentas Internas. 
 * Todos los derechos reservados
 */
package org.example.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author maza261109
 */
@AllArgsConstructor
public enum DeviceType {

    WINDOWS(
            "Windos"), WINDOWS_SERVER("Windows server"), MAC("MAC");

    @Getter
    private String descripcion;
}
