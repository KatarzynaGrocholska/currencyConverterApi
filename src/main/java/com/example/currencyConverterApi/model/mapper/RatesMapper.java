package com.example.currencyConverterApi.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RatesMapper {
    RatesMapper INSTANCE = Mappers.getMapper(RatesMapper.class);


}
