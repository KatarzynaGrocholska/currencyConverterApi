package com.example.currencyConverterApi.model.mapper;

import com.example.currencyConverterApi.model.entity.CurrencyConverter;
import com.example.currencyConverterApi.model.output_dto.CurrencyConverterAllInfoOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CurrencyConverterAllInfoMapper {

    CurrencyConverterAllInfoMapper INSTANCE = Mappers.getMapper(CurrencyConverterAllInfoMapper.class);

    List<CurrencyConverterAllInfoOutputDTO> currencyConverterTOCurrencyConverterAllInfoOutputDTOList
            (List<CurrencyConverter> currencyConverter);
}
