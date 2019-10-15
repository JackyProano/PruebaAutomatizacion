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
public enum ServiceIntellegentEnum {

    ANTIVIRUS_WIN(1L),ANTIVIRUS_MAC(2l),CLOUDBERRY(3L),PSA(4L),TEAMVIEWER(5L);
    

	@Getter
    private Long code;
}
