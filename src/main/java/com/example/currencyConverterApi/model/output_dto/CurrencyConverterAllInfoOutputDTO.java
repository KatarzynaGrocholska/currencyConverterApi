package com.example.currencyConverterApi.model.output_dto;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConverterAllInfoOutputDTO {
    private String fromCurrencyCode;
    private String toCurrencyCode;
    private double bidPrice;
    private double askPrice;
    private double bidPriceOfSecondCurrency;
    private String tradingDate;
    private double amount;
    private double valueInToCurrency;
}
