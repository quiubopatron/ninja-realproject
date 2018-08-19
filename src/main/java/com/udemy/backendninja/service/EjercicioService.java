package com.udemy.backendninja.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
@Qualifier("ejercicioService")
public class EjercicioService implements EjercicioServiceImp {

    private Log log = LogFactory.getLog(EjercicioService.class);


    @Override
    public void pintarLog() {

        log.info("Log ejercicio");

    }
}
