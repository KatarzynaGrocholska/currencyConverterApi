package com.example.currencyConverterApi.controller;

import com.example.currencyConverterApi.model.output_dto.CurrencyConverterAllInfoOutputDTO;
import com.example.currencyConverterApi.service.CurrencyConverterAllInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CurrencyConverterAllInfoController {

    private final CurrencyConverterAllInfoService currencyConverterAllInfoService;

    @GetMapping("/all-details")
    public List<CurrencyConverterAllInfoOutputDTO> showAllDetailsOfSavedQueries() {
        return currencyConverterAllInfoService.showAllColumnsInSavedQueries();
    }
}
