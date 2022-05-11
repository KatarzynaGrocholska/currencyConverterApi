package com.example.currencyConverterApi.service;

import com.example.currencyConverterApi.model.entity.TableCurrencyRates;
import com.example.currencyConverterApi.model.entity.Rates;
import com.example.currencyConverterApi.model.input_dto.RateTableInputDTO;
import com.example.currencyConverterApi.model.mapper.CurrencyRateMapper;
import com.example.currencyConverterApi.model.output_dto.TableCurrencyRateOutputDTO;
import com.example.currencyConverterApi.model.output_dto.RatesOutputDTO;
import com.example.currencyConverterApi.repository.CurrencyRatesRepository;
import com.example.currencyConverterApi.repository.RatesRepository;
import com.example.currencyConverterApi.webclient.WebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public TableCurrencyRates getCurrencyRatesQuery() {

       List<Rates> ratesListFromOneQuery = currencyRateMapper.ratesInputDTOListToRatesList
               (getTableOfCurrencyRates()
                       .getRates());
       String tradingDate = getTableOfCurrencyRates().getEffectiveDate();

       return TableCurrencyRates.builder()
               .rates(ratesListFromOneQuery)
               .tradingDate(tradingDate)
               .build();
    }

    public TableCurrencyRateOutputDTO saveCurrencyRateQuery(TableCurrencyRates tableCurrencyRates) {
        TableCurrencyRates tableCurrencyRatesQuery = currencyRatesRepository.save(tableCurrencyRates);
       List<RatesOutputDTO> ratesOutputDTOList = currencyRateMapper.ratesListToRatesOutputDTOList(ratesRepository.findAll());
       TableCurrencyRateOutputDTO tableCurrencyRateOutputDTO =currencyRateMapper.currencyRatesToCurrencyRatesOutputDTO(tableCurrencyRatesQuery);
        return TableCurrencyRateOutputDTO.builder()
                .ratesOutputDTOList(ratesOutputDTOList)
                .tradingDate(tableCurrencyRateOutputDTO.getTradingDate())
                .build();
    }
}
