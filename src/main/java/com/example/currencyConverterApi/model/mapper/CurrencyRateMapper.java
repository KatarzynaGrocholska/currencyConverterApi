package com.example.currencyConverterApi.model.mapper;

import com.example.currencyConverterApi.model.input_dto.RatesInputDTO;
import com.example.currencyConverterApi.model.output_dto.CurrencyRateOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CurrencyRateMapper {

    CurrencyRateMapper INSTANCE = Mappers.getMapper(CurrencyRateMapper.class);

    List<CurrencyRateOutputDTO> ratesInputDTOListTOCurrencyOutputDTO(List<RatesInputDTO> ratesInputDTOList);

}
