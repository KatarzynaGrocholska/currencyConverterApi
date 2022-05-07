package com.example.currencyConverterApi.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RateTableMapper {
    RateTableMapper INSTANCE = Mappers.getMapper(RateTableMapper.class);
}
