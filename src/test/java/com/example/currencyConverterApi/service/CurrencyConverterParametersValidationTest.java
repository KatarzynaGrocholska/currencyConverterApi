package com.example.currencyConverterApi.service;

import com.example.currencyConverterApi.exception.CurrencyConverterException;
import com.example.currencyConverterApi.model.input_dto.RatesInputDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyConverterParametersValidationTest {

    private CurrencyConverterParametersValidation currencyConverterParametersValidation;

    @BeforeEach
    void initializeValidation() {
        currencyConverterParametersValidation = new CurrencyConverterParametersValidation();
    }

    @Test
    void shouldThrowExceptionWhenAmountIsNegative() {
        //given
        int amount = -2;
        //when
        try {
            currencyConverterParametersValidation.checkIfAmountIsPositive(amount);

        } catch (CurrencyConverterException e) {
            //then
            assertEquals("Amount should be positive", e.getCurrencyConverterError().getMessage());
        }
    }

    @Test
    void shouldThrowExceptionWhenOneCurrencyCodeIsEmpty() {
        //given
        String currencyCodeEmpty = "";
        String currencyCodeNotNull = "PLN";
        //when
        try {
            currencyConverterParametersValidation.checkIfCurrencyCodeParameterIsEmpty(currencyCodeEmpty, currencyCodeNotNull);

        } catch (CurrencyConverterException e) {
            //then
            assertEquals("Currency code should not be null", e.getCurrencyConverterError().getMessage());
        }
    }
    @Test
    void shouldThrowExceptionWhenOneCurrenciesCodesAreTheSame() {
        //given
        String currencyCodeOne = "PLN";
        String currencyCodeTwo = "PLN";
        //when
        try {
            currencyConverterParametersValidation.checkIfCurrenciesCodesAreTheSame(currencyCodeOne,currencyCodeTwo);

        } catch (CurrencyConverterException e) {
            //then
            assertEquals("Same currencies codes", e.getCurrencyConverterError().getMessage());
        }
    }

    @Test
    void shouldThrowExceptionWhenCurrencyCodeNotExist() {
        //given
        String currencyCodeOne = "ZZZ";
        List<RatesInputDTO> currenciesFromTableList = Collections.emptyList();
        //when
        try {
            currencyConverterParametersValidation.checkIfCurrencyCodeExist(currencyCodeOne,currenciesFromTableList);

        } catch (CurrencyConverterException e) {
            //then
            assertEquals("Wrong currency code", e.getCurrencyConverterError().getMessage());
        }
    }

}