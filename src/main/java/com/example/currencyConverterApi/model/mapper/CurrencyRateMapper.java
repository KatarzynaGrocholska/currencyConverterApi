package com.example.currencyConverterApi.model.mapper;

import com.example.currencyConverterApi.model.entity.CurrencyRates;
import com.example.currencyConverterApi.model.entity.Rates;
import com.example.currencyConverterApi.model.input_dto.RatesInputDTO;
import com.example.currencyConverterApi.model.output_dto.CurrencyRateOutputDTO;
import com.example.currencyConverterApi.model.output_dto.RatesOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CurrencyRateMapper {

    CurrencyRateMapper INSTANCE = Mappers.getMapper(CurrencyRateMapper.class);

    List<Rates> ratesInputDTOListToRatesList(List<RatesInputDTO> ratesInputDTO);

    CurrencyRateOutputDTO currencyRatesToCurrencyRatesOutputDTO(CurrencyRates currencyRates);

    List<RatesOutputDTO> ratesListToRatesOutputDTOList(List<Rates> RatesList);
}
