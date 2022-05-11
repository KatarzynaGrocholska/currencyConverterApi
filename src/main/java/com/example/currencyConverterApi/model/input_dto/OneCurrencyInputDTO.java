package com.example.currencyConverterApi.model.input_dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OneCurrencyInputDTO {
    private String table;
    private String currency;
    private String code;
    private Rates[] rates;
}
