package com.impllife.data.convert;

import jakarta.persistence.AttributeConverter;

public class EnumConverter<E extends EnumWithId<ID>, ID> implements AttributeConverter<E, ID> {
    private final E[] values;

    public EnumConverter(E[] values) {
        this.values = values;
    }

    @Override
    public ID convertToDatabaseColumn(E tWithId) {
        if (tWithId == null) {
            return null;
        }
        return tWithId.getId();
    }

    @Override
    public E convertToEntityAttribute(ID t) {
        if (t == null) {
            return null;
        }
        for (E value : values) {
            if (t.equals(value.getId())) return value;
        }
        throw new IllegalArgumentException("Not exist element with id=" + t);
    }
}

