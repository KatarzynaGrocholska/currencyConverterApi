package com.example.currencyConverterApi.service;

import com.example.currencyConverterApi.exception.CurrencyConverterError;
import com.example.currencyConverterApi.exception.CurrencyConverterException;
import com.example.currencyConverterApi.model.input_dto.RatesInputDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class CurrencyConverterParametersValidation {

    public void checkIfAmountIsPositive(double amount) {
        if (amount < 0) {
            throw new CurrencyConverterException(CurrencyConverterError.AMOUNT_IS_NEGATIVE);
        }
    }

    public void checkIfCurrencyCodeParameterIsEmpty(String fromCurrency, String toCurrency) {
        if (fromCurrency.isEmpty() || toCurrency.isEmpty()) {
            throw new CurrencyConverterException(CurrencyConverterError.CURRENCY_NOT_FOUND);
        }
    }
    public void checkIfCurrencyCodeExist(String currencyCode, List<RatesInputDTO> currenciesFromTableList) {
        boolean exist = false;
        for (RatesInputDTO ratesInputDTO : currenciesFromTableList) {
            if (ratesInputDTO.getCode().equalsIgnoreCase(currencyCode)||
                    currencyCode.equalsIgnoreCase("PLN")) {
                exist = true;
            }
        }
        if (!exist) {
            throw new CurrencyConverterException(CurrencyConverterError.WRONG_CURRENCY_CODE);
        }
    }
    public void checkIfCurrenciesCodesAreTheSame(String toCurrency, String fromCurrency) {
        if (toCurrency.equalsIgnoreCase(fromCurrency)) {
            throw new CurrencyConverterException(CurrencyConverterError.SAME_CURRENCIES_CODE);
        }
    }

}

