package com.example.currencyConverterApi.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CurrencyConverterException extends RuntimeException {
    private final CurrencyConverterError currencyConverterError;
}
