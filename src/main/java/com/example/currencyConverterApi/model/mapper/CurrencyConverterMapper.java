package com.example.currencyConverterApi.model.mapper;

import com.example.currencyConverterApi.model.entity.CurrencyConverter;
import com.example.currencyConverterApi.model.output_dto.CurrencyConverterOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CurrencyConverterMapper {

    CurrencyConverterMapper INSTANCE = Mappers.getMapper(CurrencyConverterMapper.class);

    CurrencyConverterOutputDTO currencyConverterToCurrencyConverterOutputDTO
            (CurrencyConverter currencyConverter);

    List<CurrencyConverterOutputDTO> currencyConverterTOCurrencyConverterOutputDTOList
            (List<CurrencyConverter> currencyConverter);

}
