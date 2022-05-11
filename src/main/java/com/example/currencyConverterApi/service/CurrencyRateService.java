package com.example.currencyConverterApi.service;

import com.example.currencyConverterApi.model.entity.CurrencyRates;
import com.example.currencyConverterApi.model.entity.Rates;
import com.example.currencyConverterApi.model.input_dto.RateTableInputDTO;
import com.example.currencyConverterApi.model.input_dto.RatesInputDTO;
import com.example.currencyConverterApi.model.mapper.CurrencyRateMapper;
import com.example.currencyConverterApi.model.output_dto.CurrencyRateOutputDTO;
import com.example.currencyConverterApi.model.output_dto.RatesOutputDTO;
import com.example.currencyConverterApi.repository.CurrencyRatesRepository;
import com.example.currencyConverterApi.repository.RatesRepository;
import com.example.currencyConverterApi.webclient.WebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyRateService {

    private final WebClient webClient;
    private final CurrencyRateMapper currencyRateMapper;
private final RatesRepository ratesRepository;
    private final CurrencyRatesRepository currencyRatesRepository;

    public RateTableInputDTO getTableOfCurrencyRates() {
        return webClient.callApi();
    }

    public CurrencyRates getCurrencyRatesQuery() {

       List<Rates> ratesListFromOneQuery = currencyRateMapper.ratesInputDTOListToRatesList
               (getTableOfCurrencyRates()
                       .getRates());
       String tradingDate = getTableOfCurrencyRates().getEffectiveDate();

       return CurrencyRates.builder()
               .rates(ratesListFromOneQuery)
               .tradingDate(tradingDate)
               .build();
    }

    public CurrencyRateOutputDTO saveCurrencyRateQuery(CurrencyRates currencyRates) {
        CurrencyRates currencyRatesQuery = currencyRatesRepository.save(currencyRates);
       List<RatesOutputDTO> ratesOutputDTOList = currencyRateMapper.ratesListToRatesOutputDTOList(ratesRepository.findAll());
       CurrencyRateOutputDTO currencyRateOutputDTO =currencyRateMapper.currencyRatesToCurrencyRatesOutputDTO(currencyRatesQuery);
        return CurrencyRateOutputDTO.builder()
                .ratesOutputDTOList(ratesOutputDTOList)
                .tradingDate(currencyRateOutputDTO.getTradingDate())
                .build();
    }

}
