package com.example.currencyConverterApi.service;

import com.example.currencyConverterApi.model.mapper.CurrencyConverterMapper;
import com.example.currencyConverterApi.repository.CurrencyConverterRepository;
import com.example.currencyConverterApi.webclient.WebClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConvertServiceTest {


    private CurrencyConvertService currencyConvtertService;
    private WebClient webClient;
    private CurrencyRateService currencyRateService;
    private CurrencyConverterRepository currencyConverterRepository;
    private CurrencyConverterMapper currencyConverterMapper;
    private CurrencyConverterParametersValidation currencyConverterParametersValidation;

    @BeforeEach
    void initializeService() {
        currencyConvtertService = new CurrencyConvertService(webClient,currencyRateService,
                currencyConverterRepository,currencyConverterMapper,currencyConverterParametersValidation);
    }

    @Test
    void shouldCountValueInToCurrencyIfGivenIsPLN(){
        //given
        double askPrice=5;
        double amount =20;
        //when
       double actual = currencyConvtertService.calculateValueIfFromCurrencyIsPLN(amount,askPrice);
       // then
        assertEquals(4,actual);
    }
    @Test
    void shouldCountValueInFromCurrencyIfGivenIsPLN(){
        //given
        double bidPrice=5;
        double amount =20;
        //when
        double actual = currencyConvtertService.calculateValueIfToCurrencyIsPLN(amount,bidPrice);
        // then
        assertEquals(100,actual);
    }

    @Test
    void shouldCountValueInToCurrencyIfGivenAreTwoCurrenciesNotPLN(){
        //given
        double bidPrice=5;
        double amount =20;
        double askSecondCurrencyPrice=10;
        //when
        double actual = currencyConvtertService.countValueInToCurrency(bidPrice,askSecondCurrencyPrice,amount);
        // then
        assertEquals(10,actual);

    }


}