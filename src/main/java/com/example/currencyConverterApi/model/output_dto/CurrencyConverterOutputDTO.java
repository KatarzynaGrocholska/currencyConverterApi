package com.example.currencyConverterApi.model.output_dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConverterOutputDTO {
    private String fromCurrencyCode;
    private String toCurrencyCode;
    private String tradingDate;
    private double amount;
    private double valueInToCurrency;

}
