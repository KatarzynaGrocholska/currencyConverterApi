package com.example.currencyConverterApi.controller;

import com.example.currencyConverterApi.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping("/all-currencies")
    public List<String> getAllCurrenciesAndRates() {
        return currencyService.showAllCurrencies();
    }

}
