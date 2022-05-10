package com.example.currencyConverterApi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRateService currencyRateService;

    public List<String> showAllCurrencies() {
        List<String> listOfCurrencies = new ArrayList<>();
        for (int i = 0; i < currencyRateService.showAllCurrenciesAndRates().size(); i++) {
            listOfCurrencies.add(currencyRateService.showAllCurrenciesAndRates().get(i).getCurrency());
        }
        return listOfCurrencies;
    }

}
