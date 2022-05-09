package com.example.currencyConverterApi.model.mapper;

import com.example.currencyConverterApi.model.entity.CurrencyConverter;
import com.example.currencyConverterApi.model.input_dto.RateTableInputDTO;
import com.example.currencyConverterApi.model.input_dto.RatesInputDTO;
import com.example.currencyConverterApi.model.output_dto.CurrencyConverterOutputDTO;
import com.example.currencyConverterApi.model.output_dto.CurrencyRateOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CurrencyConverterMapper {

    CurrencyConverterMapper INSTANCE = Mappers.getMapper(CurrencyConverterMapper.class);

    CurrencyConverterOutputDTO currencyConverterToCurrencyConverterOutputDTO(CurrencyConverter currencyConverter);
    List<CurrencyConverterOutputDTO> currencyConverterTOCurrencyConverterOutputDTOList(List<CurrencyConverter> currencyConverter);
    CurrencyConverter RatesInputDTOToCurrencyConverter(RatesInputDTO ratesInputDTO);
    CurrencyConverter RateTableInputDTOToCurrencyConverter(RateTableInputDTO rateTableInputDTO);
}
