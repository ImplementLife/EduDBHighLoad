package com.impllife.data.entity;

import com.impllife.data.convert.EnumWithId;

public enum OrderStatus implements EnumWithId<Character> {
    IN_PROCESS('P'),
    WAIT_PAY('W'),
    SEND('S'),
    ;

    private final char id;

    OrderStatus(char id) {
        this.id = id;
    }

    @Override
    public Character getId() {
        return id;
    }
}
