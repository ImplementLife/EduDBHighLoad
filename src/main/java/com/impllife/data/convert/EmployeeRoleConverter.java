package com.impllife.data.convert;

import com.impllife.data.entity.EmployeeRole;

public class EmployeeRoleConverter extends EnumConverter<EmployeeRole, Character> {
    public EmployeeRoleConverter() {
        super(EmployeeRole.values());
    }
}
