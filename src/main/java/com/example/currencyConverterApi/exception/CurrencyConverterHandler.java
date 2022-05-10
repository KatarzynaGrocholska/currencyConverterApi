package com.example.currencyConverterApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CurrencyConverterHandler {


    @ExceptionHandler(value = CurrencyConverterException.class)
    public ResponseEntity<CurrencyConverterErrorInfo> handlerActivityException(CurrencyConverterException e) {
        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;
        if (e.getCurrencyConverterError().equals(CurrencyConverterError.CURRENCY_NOT_FOUND)) {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return ResponseEntity.status(httpStatus).body(new CurrencyConverterErrorInfo(e.getCurrencyConverterError().getMessage()));
    }


}
