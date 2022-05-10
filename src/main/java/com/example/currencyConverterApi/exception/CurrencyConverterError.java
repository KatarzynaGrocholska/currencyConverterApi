package com.example.currencyConverterApi.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CurrencyConverterError {

    CURRENCY_NOT_FOUND("Currency code should not be null"),
    AMOUNT_IS_NEGATIVE("Amount should be positive"),
    WRONG_CURRENCY_CODE("Wrong currency code"),
    SAME_CURRENCIES_CODE("Same currencies codes");

    private final String message;
}
