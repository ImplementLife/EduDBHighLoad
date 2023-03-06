package com.impllife.data.convert;

import com.impllife.data.entity.TwoFactorAuthType;

import javax.persistence.Converter;

@Converter
public class TwoFactorAuthTypeConverter extends EnumConverter<TwoFactorAuthType, Character> {
    public TwoFactorAuthTypeConverter() {
        super(TwoFactorAuthType.values());
    }
}
