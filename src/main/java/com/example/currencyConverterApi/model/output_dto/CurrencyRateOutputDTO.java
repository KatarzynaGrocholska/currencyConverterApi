package com.example.currencyConverterApi.model.output_dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRateOutputDTO {
    private String currency;
    private String code;
    private String bid;
    private String ask;
}
