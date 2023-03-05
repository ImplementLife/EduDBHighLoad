package com.impllife.data.convert;

import com.impllife.data.entity.TwoFactorAuthType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TwoFactorAuthTypeConverter implements AttributeConverter<TwoFactorAuthType, Character> {
    private final EnumConverter<TwoFactorAuthType, Character> converter = new EnumConverter<>(TwoFactorAuthType.values());

    @Override
    public Character convertToDatabaseColumn(TwoFactorAuthType twoFactorAuthType) {
        return converter.convertToDatabaseColumn(twoFactorAuthType);
    }

    @Override
    public TwoFactorAuthType convertToEntityAttribute(Character character) {
        return converter.convertToEntityAttribute(character);
    }
}
