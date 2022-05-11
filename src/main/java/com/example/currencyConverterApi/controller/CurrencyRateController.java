package com.example.currencyConverterApi.controller;

import com.example.currencyConverterApi.model.output_dto.TableCurrencyRateOutputDTO;
import com.example.currencyConverterApi.service.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CurrencyRateController {

    private final CurrencyRateService currencyRateService;

    @GetMapping("/rates")
    public TableCurrencyRateOutputDTO getCurrenciesAndRatesList() {
        return currencyRateService.saveCurrencyRateQuery(currencyRateService.getCurrencyRatesQuery());
    }
}
