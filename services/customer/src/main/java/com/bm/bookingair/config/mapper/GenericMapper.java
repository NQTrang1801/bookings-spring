package com.bm.bookingair.config.mapper;

public interface GenericMapper<S, T> {
    <T> T map(Object source, Class<T> targetType, String mappingType);
}

