package com.example.currencyConverterApi.service;

import com.example.currencyConverterApi.model.entity.CurrencyConverter;
import com.example.currencyConverterApi.model.mapper.CurrencyConverterMapper;
import com.example.currencyConverterApi.repository.CurrencyConverterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CurrencyConvertServiceTest {

    private CurrencyConvertService currencyConverterService;
    private  CurrencyRateService currencyRateService;
    private  CurrencyConverterRepository currencyConverterRepository;
    private  CurrencyConverterMapper currencyConverterMapper;
    private  CurrencyConverterParametersValidation currencyConverterParametersValidation;

    @BeforeEach
    void initializeValidation() {
        currencyConverterService = new CurrencyConvertService
                (currencyRateService,currencyConverterRepository,
                        currencyConverterMapper,currencyConverterParametersValidation);
    }

//    @Test
//    void shouldReturnValueInToCurrencyWhenGivenFromCurrencyAndAmount(){
//        //given
//        String fromCurrency="USD";
//        String toCurrency="PLN";
//        double amount =100;
//        //when
//        CurrencyConverter value = currencyConverterService.countValueOfGivenAmountInFromCurrencyToCurrency
//                (fromCurrency,toCurrency,amount);
//        //then
//        assertEquals(CurrencyConverter.builder().toCurrencyCode("PLN")
//                .fromCurrencyCode("USD")
//                .valueInToCurrency(4.56)
//                .amount(100)
//                .tradingDate("10-05-2022")
//                .askPrice(4.15)
//                .bidPrice(4.24)
//                .askPriceOfSecondCurrency(4.12)
//                .build(),value);
//    }

}