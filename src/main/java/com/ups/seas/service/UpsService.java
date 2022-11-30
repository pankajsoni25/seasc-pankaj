package com.ups.seas.service;

import com.ups.seas.exception.EmployeeNotFound;
import com.ups.seas.exception.UpsException;
import com.ups.seas.model.UpsEmployee;
import com.ups.seas.repository.UpsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UpsService {

    @Autowired
    UpsRepository upsRepository;


    public UpsEmployee getEmployeeDetails(String employeeId) throws EmployeeNotFound {
        log.info("[UpsService][getEmployeeDetails] is called, employeeId: {} ", employeeId);
        UpsEmployee upsEmployee = upsRepository.getEmployeeDetails(employeeId);
        if (upsEmployee == null) {
            String msg = "Employee Not found !";
            log.error("[UpsController][getEmployeeDetails] is called, Exception msg: {} ", msg);
            throw new UpsException(HttpStatus.BAD_REQUEST, "employee not found");
        }
        return upsEmployee;
    }

}
