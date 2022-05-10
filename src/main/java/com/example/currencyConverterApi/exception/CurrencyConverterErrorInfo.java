package com.example.currencyConverterApi.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CurrencyConverterErrorInfo {

    private final String message;

}
