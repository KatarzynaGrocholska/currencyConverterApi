package com.example.currencyConverterApi.service;

import com.example.currencyConverterApi.model.input_dto.RateTableInputDTO;
import com.example.currencyConverterApi.model.mapper.CurrencyRateMapper;

import com.example.currencyConverterApi.model.output_dto.CurrencyRateOutputDTO;
import com.example.currencyConverterApi.webclient.WebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyRateService {

    private final WebClient webClient;
    private final CurrencyRateMapper currencyRateMapper;

    public RateTableInputDTO getTableOfCurrencyRates() {
        return webClient.callApi();
    }

    public List<CurrencyRateOutputDTO> showAllCurrenciesAndRates() {
        return currencyRateMapper.ratesInputDTOListTOCurrencyOutputDTO(getTableOfCurrencyRates().getRates());
    }
}
