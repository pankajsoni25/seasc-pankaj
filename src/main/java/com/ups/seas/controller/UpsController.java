package com.ups.seas.controller;

import com.ups.seas.exception.EmployeeNotFound;
import com.ups.seas.model.UpsEmployee;
import com.ups.seas.service.UpsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@Slf4j
public class UpsController {

    @Autowired
    UpsService upsService;

    @GetMapping("/getByEmployeeId")
    public ResponseEntity<UpsEmployee> getEmployeeDetails(@RequestParam(name = "employeeId") String employeeId) throws EmployeeNotFound {
        log.info("[UpsController][getEmployeeDetails] is called, employeeId: {} ", employeeId);
        return ResponseEntity.ok(upsService.getEmployeeDetails(employeeId));

    }


}