package com.impllife.data.convert;

import com.impllife.data.entity.TwoFactorAuthType;

import jakarta.persistence.Converter;

@Converter
public class TwoFactorAuthTypeConverter extends EnumConverter<TwoFactorAuthType, Character> {
    public TwoFactorAuthTypeConverter() {
        super(TwoFactorAuthType.values());
    }
}
