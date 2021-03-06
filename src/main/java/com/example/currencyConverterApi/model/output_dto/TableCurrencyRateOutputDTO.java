package com.example.currencyConverterApi.model.output_dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableCurrencyRateOutputDTO {

    private String tradingDate;
    private List<RatesOutputDTO> ratesOutputDTOList;
}
