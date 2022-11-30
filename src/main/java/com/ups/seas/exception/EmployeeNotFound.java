package com.ups.seas.exception;

public class EmployeeNotFound extends Exception {

    private String msg;

    public EmployeeNotFound(String msg) {
        super(msg);
        this.msg = msg;
    }
}