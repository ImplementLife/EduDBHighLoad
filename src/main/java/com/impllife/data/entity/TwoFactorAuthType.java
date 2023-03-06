package com.impllife.data.entity;

import com.impllife.data.convert.EnumWithId;

public enum TwoFactorAuthType implements EnumWithId<Character> {
    VIBER('V'),
    TELEGRAM('T'),
    SMS('S'),
    VIA_TELEPHONE_CALL('C'),
    ;

    private final char c;
    TwoFactorAuthType(char c) {
        this.c = c;
    }

    public Character getId() {
        return c;
    }
}
