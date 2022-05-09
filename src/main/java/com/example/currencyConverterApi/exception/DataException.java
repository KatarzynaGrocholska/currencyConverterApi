package com.example.currencyConverterApi.exception;

public class DataException extends RuntimeException{

    public DataException() {
        super("Wrong data type");
    }
}
