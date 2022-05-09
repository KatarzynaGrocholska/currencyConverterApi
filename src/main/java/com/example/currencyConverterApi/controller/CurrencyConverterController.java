package com.example.currencyConverterApi.controller;

import com.example.currencyConverterApi.model.output_dto.CurrencyConverterOutputDTO;
import com.example.currencyConverterApi.service.CurrencyConvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CurrencyConverterController {

    private final CurrencyConvertService currencyConvertService;

    @GetMapping("/nbp")
    public CurrencyConverterOutputDTO getConversionDataAndSaveQuery(@RequestParam String from,
                                                        @RequestParam String to,
                                                        @RequestParam double amount) {

        return currencyConvertService.saveCurrencyConverterQuery
                (currencyConvertService.countValueOfGivenAmountInFromCurrencyToCurrency
                        (from, to, amount));

    }
    @GetMapping("/list")
public List<CurrencyConverterOutputDTO> showAllSavedQueries(){
        return currencyConvertService.showAllSavedQueries();
}
}
