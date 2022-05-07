package com.example.currencyConverterApi.model.output_dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConverterOutputDTO {
    private String fromCurrencyCode;
    private String toCurrencyCode;
    private double bidPrice;
    private double askPrice;
    private double askPriceOfSecondCurrency;
    private String tradingDate;
    private double amount;
    private double valueInToCurrency;

}
