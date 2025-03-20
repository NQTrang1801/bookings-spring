package com.bm.bookingair.common.mapper;

public interface GenericMapper<S, T> {
    <T> T map(Object source, Class<T> targetType, String mappingType);
}

