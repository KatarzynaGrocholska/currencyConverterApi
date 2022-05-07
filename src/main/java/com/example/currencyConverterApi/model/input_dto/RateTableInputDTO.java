package com.example.currencyConverterApi.model.input_dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RateTableInputDTO {
    private String table;
    private String no;
    private String effectiveDate;
    private List<RatesInputDTO> rates;
}
