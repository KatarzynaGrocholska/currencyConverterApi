package com.example.currencyConverterApi.controller;

import com.example.currencyConverterApi.model.output_dto.CurrencyRateOutputDTO;
import com.example.currencyConverterApi.service.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CurrencyRateController {
    private final CurrencyRateService currencyRateService;

    @GetMapping("/all-info")
    public List<CurrencyRateOutputDTO> getAllCurrenciesAndRates() {
        return currencyRateService.showAllCurrenciesAndRates();
    }
}
