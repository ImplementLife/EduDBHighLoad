package com.impllife.data.entity;

import com.impllife.data.convert.EnumWithId;

public enum EmployeeRole implements EnumWithId<Character> {
    WAREHOUSE_LOADER('W'),
    SALES_MANAGER('S'),
    PROMOTION('P'),
    ACCOUNTANT('A'),
    ;

    private final char id;

    EmployeeRole(char id) {
        this.id = id;
    }

    @Override
    public Character getId() {
        return id;
    }
}
