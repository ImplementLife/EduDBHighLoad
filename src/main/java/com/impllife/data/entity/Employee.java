package com.impllife.data.entity;

import com.impllife.data.convert.EmployeeRoleConverter;

import jakarta.persistence.Convert;

public class Employee extends Person {

    private double basePayment;

    @Convert(converter = EmployeeRoleConverter.class)
    private EmployeeRole role;
}
